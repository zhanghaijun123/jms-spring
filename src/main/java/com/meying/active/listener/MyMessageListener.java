package com.meying.active.listener;

import org.springframework.jms.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @Description: 自定义消息接收监听器
 * @Author zhanghj
 * @Date 2021/2/8 17:50
 */
@Component
public class MyMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        if(null!=message && message instanceof TextMessage){
            try {
                TextMessage msg= (TextMessage) message;
                System.out.println("监听器接收到的消息===="+msg.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
