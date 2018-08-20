package com.exampleDemo.ActivemqTest.receiver;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 单个接收消息
 */
public class JMSQueueReceiver {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory
                = new ActiveMQConnectionFactory("tcp://192.168.6.128:61616?jms.optimizeAcknowledge=true");
        Connection connection = null;
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(Boolean.FALSE, Session.DUPS_OK_ACKNOWLEDGE);
            Destination destination = session.createQueue("myQueue");
            MessageConsumer consumer = session.createConsumer(destination);
            TextMessage message = (TextMessage) consumer.receive();
            System.out.println(message.getText());

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
