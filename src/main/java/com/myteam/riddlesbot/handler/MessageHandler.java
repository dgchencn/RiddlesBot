package com.myteam.riddlesbot.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.myteam.riddlesbot.bean.UserCondition;
import com.myteam.riddlesbot.pojo.OpCode0Message;
import com.myteam.riddlesbot.pojo.OpCode2Identify;
import com.myteam.riddlesbot.util.HttpUtil;
import com.myteam.riddlesbot.util.WebSocketClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.Session;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class MessageHandler {
    private final static Logger logger = LoggerFactory.getLogger(MessageHandler.class);
    static Map<String, UserCondition> conditionMap = new HashMap<>();

    @Autowired
    private HttpUtil httpUtil;

    public void handler(WebSocketClient webSocketClient, String message){
        //解析第一层数据
        JSONObject data = JSON.parseObject(message);
        String op = data.getString("op");
        //说明是服务端进行消息推送
        if (op.equals("0")) {
            OpCode0Message msg = JSON.parseObject(JSON.parse(message).toString(), OpCode0Message.class);
            //证明是用户发来的消息
            if (msg.getD().getAuthor() != null) {
                logger.info(msg.getD().getContent());
                String userId = msg.getD().getAuthor().getId();
//                String content = msg.getD().getContent().substring(msg.getD().getContent().indexOf(" ")+1,msg.getD().getContent().length());
                String content = msg.getD().getContent().replaceAll("\\<@!.*?> ","");
                //初始化用户的状态信息
                if (!conditionMap.containsKey(userId)) {
                    conditionMap.put(userId,new UserCondition());
                }
                UserCondition userCondition = conditionMap.get(userId);
                String authorId = msg.getD().getAuthor().getId();
                String channelId = msg.getD().getChannel_id();
                String msgId = msg.getD().getId();
                String sendContent = "<@!"+authorId+"> ";   //能够起到@用户的作用
                switch (userCondition.getStatus()){    //判断当前用户处于哪个阶段
                    case 0:
                        if ("开始".equals(content)) {
                            //发送灯谜
                            httpUtil.postMessage(channelId,sendContent+userCondition.getLanternRiddle().getRiddle(), msgId);
                            userCondition.setStatus(userCondition.getStatus()+1);
                        }else {
                            //发送玩法
                            httpUtil.postMessage(channelId,sendContent+"快来和我玩灯谜，请@我说“开始”，进入猜灯谜游戏吧", msgId);
                        }
                        break;
                    case 1:
                        userCondition.setStep(userCondition.getStep()+1);
                        if (userCondition.getLanternRiddle().getAnswer().equals(content)) {
                            //发送成功提示
                            httpUtil.postMessage(channelId,sendContent+"恭喜你答对了，请@我说“抽奖”，抽取你的奖品", msgId);
                            userCondition.setStatus(userCondition.getStatus()+1);
                        }else if ("公布谜底".equals(content)) {
                            httpUtil.postMessage(channelId,sendContent+"谜底是："+userCondition.getLanternRiddle().getAnswer()+"，聪明的你一定有想到吧哈哈哈", msgId);
                            userCondition.setStatus(userCondition.getStatus()+2);
                        }else {
                            //发送错误提示
                            httpUtil.postMessage(channelId,sendContent+"不对，再猜猜", msgId);
                            //判断是否猜的次数过多
                            if (userCondition.getStep() < 5)
                                httpUtil.postMessage(channelId,sendContent+"你已经答错"+userCondition.getStep()+"次了，加油哦", msgId);
                            else
                                httpUtil.postMessage(channelId,sendContent+"你已经答错"+userCondition.getStep()+"次了，实在累了就@我说“公布谜底”吧", msgId);
                        }
                        break;
                    case 2:
                        if ("抽奖".equals(content)) {
                            //发送抽奖结果
                            httpUtil.postMessage(channelId,sendContent+"恭喜，你的奖品是： "+userCondition.getReward(), msgId);
                            userCondition.setStatus(userCondition.getStatus()+1);
                        }else {
                            //发送错误提示
                            httpUtil.postMessage(channelId,sendContent+"土豪，你不想领奖了吗", msgId);
                            httpUtil.postMessage(channelId,sendContent+"请@我说“抽奖”", msgId);
                        }
                        break;
                    default:
                        httpUtil.postMessage(channelId,sendContent+"感谢你完成了一轮猜灯谜游戏，接下来将重新开始哦", msgId);
                        //重置用户状态信息
                        conditionMap.put(userId,new UserCondition());
                }
            }
        }else if(op.equals("7")) {
            //关闭session，重新连接
            webSocketClient.closeSession();
            //发送一个 OpCode 2 Identify 消息，进行鉴权
            webSocketClient.sendMsg(JSON.toJSONString(new OpCode2Identify()));
        }
    }

}
