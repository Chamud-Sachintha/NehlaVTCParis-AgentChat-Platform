package com.nehlavtcparis.chat.controller;

import com.nehlavtcparis.chat.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/private-message")
    public Message recievePrivateMessage(@Payload Message message) {
        this.simpMessagingTemplate.convertAndSendToUser(message.getRecieverName(), "/private", message);
        return message;
    }
}
