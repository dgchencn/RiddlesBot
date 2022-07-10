package com.myteam.riddlesbot.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.myteam.riddlesbot.handler.MessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import java.net.URI;

/**
 * 以客户端的方式请求连接 websocket 服务端
 */
@Component
@ClientEndpoint
public class WebSocketClient {
    private final static Logger logger = LoggerFactory.getLogger(WebSocketClient.class);

    private static MessageHandler msgHandler;

    @Autowired
    public void setMsgHandler(MessageHandler msgHandler) {
        WebSocketClient.msgHandler = msgHandler;
    }

    private String uri = "wss://sandbox.api.sgroup.qq.com/websocket";

    private static Session session;

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void initSession() {
        if (session == null){
            WebSocketContainer container = null;
            try {
                container = ContainerProvider.getWebSocketContainer();
                URI r = URI.create(uri);
                session = container.connectToServer(WebSocketClient.class, r);
            } catch (Exception e) {
                logger.error(e.toString());
            }
        }
    }

    @OnOpen
    public void onOpen(Session session) {
        logger.info("Client onOpen");
    }
    @OnMessage
    public void onMessage(String message) {
        logger.info("Client onMessage: " + message);
        msgHandler.handler(this,message);
    }
    @OnClose
    public void onClose() {
        logger.info("Client onClose");
    }

    //发送消息到QQ机器人服务端
    public void sendMsg(String param) {
        try {
            //如果session为空，需要先进行连接
            if (session == null) initSession();
            session.getBasicRemote().sendText(param);
        } catch (Exception e) {
            logger.error(e.toString());
        }
    }

    public  void closeSession() {
        try {
            if (session != null) {
                session.close();
                session = null;
            }
        } catch (Exception e) {
            logger.error(e.toString());
        }
    }
}
