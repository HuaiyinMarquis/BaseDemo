package com.exampleDemo.ActivemqTest.producer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * ActiveMQ支持消息的同步和异步发送两种方式。
 *      1、持久化消息默认是同步发送。
 *      2、非持久化消息默认是异步发送，异步发送的消息可能出现丢失的情况。
 *      3、在开启事务的情况系，消息都是异步发送的。
 */
public class JMSQueueProducer {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory("tcp://192.168.6.128:61616");
        Connection connection = null;
        try {
//            ((ActiveMQConnectionFactory) connectionFactory).setOptimizeAcknowledge(true);
            connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(Boolean.FALSE, Session.CLIENT_ACKNOWLEDGE);
            Destination destination = session.createQueue("myQueue");
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);//持久化存储
            for (int i=0; i<100; i++) {
                TextMessage message = session.createTextMessage("Hello World " + i);
                producer.send(message);
//                if (i == 50)
//                    message.acknowledge(); 在producer端无效
            }

//            session.commit();
            session.close();
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
