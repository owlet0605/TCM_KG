package com.example.tcm_kgsystem.service.Util;

import com.example.tcm_kgsystem.entity.ChatMessage;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value = "/websocket/{userId}")
@Component
public class WebSocketUtil {

    private static CopyOnWriteArraySet<WebSocketUtil> webSocketSet = new CopyOnWriteArraySet<>();
    private static Map<Long, Session> map = new HashMap<>();
    private Session session;
    private long userId;
    private ApplicationContext applicationContext;

    @OnOpen
    public void onOpen(Session session, @PathParam("userId") long userId) {
        this.session = session;
        this.userId = userId;

        map.put(userId, session);

        System.out.println("connect "+userId);
        webSocketSet.add(this);
    }

    @OnClose
    public void onClose() {
        System.out.println("close "+userId);
        webSocketSet.remove(this);

    }

    @OnMessage
    public void onMessage(String message) {

        ObjectMapper objectMapper = new ObjectMapper();
        ChatMessage chatMsg;

        try {
            chatMsg = objectMapper.readValue(message, ChatMessage.class);

            Session fromSession = map.get(chatMsg.getFromUserId());
            Session toSession = map.get(chatMsg.getToUserId());

            fromSession.getAsyncRemote().sendText(objectMapper.writeValueAsString(chatMsg));

            if (toSession != null) {
                toSession.getAsyncRemote().sendText(objectMapper.writeValueAsString(chatMsg));
            }

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    public void broadcast(String message) {
        for (WebSocketUtil item : webSocketSet) {

            //异步发送消息.
            item.session.getAsyncRemote().sendText(message);
        }
    }
}

