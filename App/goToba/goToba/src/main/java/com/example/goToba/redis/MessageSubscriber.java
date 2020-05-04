package com.example.goToba.redis;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 29/04/2020.
 */
@Service
public class MessageSubscriber implements MessageListener {
    public static List<String> list = new ArrayList<String>();
    @Override
    public void onMessage(Message message, byte[] bytes) {
        list.add(message.toString());
        System.out.println("Message received: " + new String(message.getBody()));
    }
}
