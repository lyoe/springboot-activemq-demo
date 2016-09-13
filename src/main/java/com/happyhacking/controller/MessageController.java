package com.happyhacking.controller;

import com.happyhacking.message.SimpleMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhouqin on 9/13/16.
 */
@RestController
public class MessageController {

    @Autowired
    private SimpleMessageProducer simpleMessageProducer;

    @RequestMapping("/trigger/{count}")
    public void trigger(@PathVariable int count) {
        simpleMessageProducer.sendMessages(count);
    }
}
