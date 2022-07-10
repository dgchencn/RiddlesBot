package com.myteam.riddlesbot.handler;

import com.alibaba.fastjson.JSON;
import com.myteam.riddlesbot.pojo.OpCode10Hello;
import com.myteam.riddlesbot.pojo.OpCode1Heart;
import com.myteam.riddlesbot.pojo.OpCode2Identify;
import com.myteam.riddlesbot.util.HttpUtil;
import com.myteam.riddlesbot.util.WebSocketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * springboot启动完成后，自动执行本实例的run方法
 */
@Component
@Order(value = 1)
public class AfterRunner implements ApplicationRunner {

    @Autowired
    private WebSocketClient webSocketClient;

    @Autowired
    private HttpUtil httpUtil;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        webSocketClient.setUri(httpUtil.getGateway());
        //发送Hello消息，进行 websocket 连接
        webSocketClient.sendMsg(JSON.toJSONString(new OpCode10Hello()));
        //发送一个 OpCode 2 Identify 消息，进行鉴权
        webSocketClient.sendMsg(JSON.toJSONString(new OpCode2Identify()));
        //启动心跳线程，保持连接活跃
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(45000);
                        webSocketClient.sendMsg(JSON.toJSONString(new OpCode1Heart()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"Heartbeat").start();
    }
}

