package com.happyhacking.message;

import java.util.Date;

import javax.jms.Destination;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by zhouqin on 9/13/16.
 */
@Service
public class SimpleMessageProducer {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Destination virtualTopic;

    public void sendMessages(int count) {

        StringBuilder payload = null;

        for (int i = 0; i < count; i++) {
            payload = new StringBuilder();
            payload.append("payload is [").append(i).append("], created at ").append(new Date());

            final String s = payload.toString();

            jmsTemplate.send(virtualTopic, session -> {
                TextMessage message = session.createTextMessage();
                message.setText(s);

                return message;
            });
        }
    }
}
