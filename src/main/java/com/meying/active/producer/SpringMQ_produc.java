package com.meying.active.producer;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.apache.xbean.spring.context.XmlWebApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.ConnectionFactory;
import javax.jms.TextMessage;

/**
 * @Description: 消息队列生产者
 * @Author zhanghj
 * @Date 2021/2/8 17:10
 */
@Service
public class SpringMQ_produc {
    @Autowired
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-activemq.xml");
       SpringMQ_produc produc= (SpringMQ_produc) ctx.getBean("springMQ_produc");
       produc.jmsTemplate.send((session)->{
           TextMessage textMessage = session.createTextMessage(">>>spring-active-msg");
           return textMessage;
       });
        System.out.println("spring消息发送完成");
    }

}
