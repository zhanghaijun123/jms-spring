package com.meying.active.consume;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.TextMessage;

/**
 * @Description: 队列消息接受者
 * @Author zhanghj
 * @Date 2021/2/8 17:31
 */
@Service
public class SpringMQ_consume {
    @Autowired
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        ApplicationContext ctx=new  ClassPathXmlApplicationContext("spring-activemq.xml");
        SpringMQ_consume consume= (SpringMQ_consume) ctx.getBean("springMQ_consume");
        String message= (String) consume.jmsTemplate.receiveAndConvert();
        System.out.println("接收到的消息："+message);
    }
}
