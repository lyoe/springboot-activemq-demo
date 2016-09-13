package com.happyhacking.message;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * Created by zhouqin on 9/13/16.
 */
@Service
public class SimpleMessageConsumer implements MessageListener {

    private final static Logger LOGGER = LoggerFactory.getLogger(SimpleMessageConsumer.class);

    @Override
    @JmsListener(destination = "Consumer.CSA.VirtualTopic.FOO.BAR")
    public void onMessage(Message message) {

        try {
            TextMessage tm = (TextMessage) message;
            LOGGER.info("Consumer CSA: " + tm.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
