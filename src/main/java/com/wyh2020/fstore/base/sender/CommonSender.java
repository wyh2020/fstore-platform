package com.wyh2020.fstore.base.sender;


import com.wyh2020.fstore.base.util.ObjectMapperUtil;
import lombok.AllArgsConstructor;
import org.springframework.jms.core.JmsMessagingTemplate;

import javax.jms.Destination;

/**
 * Created by hzh on 2018/3/31.
 */
@AllArgsConstructor
public class CommonSender {
    private JmsMessagingTemplate jmsMessagingTemplate;



    public void sendMessage(Destination destination,  String message) {
        this.jmsMessagingTemplate.convertAndSend(destination, message);
    }

    public void sendMessage(Destination destination, Object message) {
        this.jmsMessagingTemplate.convertAndSend(destination, ObjectMapperUtil.writeValueAsString(message));
    }
}
