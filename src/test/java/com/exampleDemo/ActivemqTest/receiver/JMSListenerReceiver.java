package com.exampleDemo.ActivemqTest.receiver;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 利用MessageListener监听服务器上的消息
 */
public class JMSListenerReceiver {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory
                = new ActiveMQConnectionFactory("tcp://192.168.6.128:61616");
        Connection connection = null;
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("myQueue");
            MessageConsumer consumer = session.createConsumer(destination);

            MessageListener messageListener = new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    try {
                        System.out.println(((TextMessage) message).getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            };

            while (true){
                consumer.setMessageListener(messageListener);
                Thread.sleep(1000);
                session.commit();
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
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
