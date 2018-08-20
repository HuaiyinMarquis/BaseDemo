package com.exampleDemo.ActivemqTest.receiver;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JMSTopicReceiver01 {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory
                = new ActiveMQConnectionFactory("tcp://192.168.6.128:61616");
        Connection connection = null;
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createTopic("myTopic");
            MessageConsumer consumer = session.createConsumer(destination);

            TextMessage message = (TextMessage) consumer.receive();
            System.out.println(message.getText());
            session.commit();
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
