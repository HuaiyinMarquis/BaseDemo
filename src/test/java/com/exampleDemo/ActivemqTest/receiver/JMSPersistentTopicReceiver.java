package com.exampleDemo.ActivemqTest.receiver;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JMSPersistentTopicReceiver {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory
                = new ActiveMQConnectionFactory("tcp://192.168.6.128:61616");

        Connection connection = null;
        try {
            connection = connectionFactory.createConnection();
            connection.setClientID("009");
            connection.start();

            Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            Topic destination= session.createTopic("myTopic");
            TopicSubscriber durableSubscriber = session.createDurableSubscriber(destination, "007");
            TextMessage message = (TextMessage) durableSubscriber.receive();

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
