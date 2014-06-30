package com.dp.jms.activemq;

/*
 * 消息接收者
 */
import java.util.Date;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MapMessage;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageReceiver {
    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();

        
        Connection connection = connectionFactory.createConnection();
        connection.start();

        final Session session = connection.createSession(Boolean.TRUE,
                Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("my-queue");

        MessageConsumer consumer = session.createConsumer(destination);

        int i = 0;
        while (i < 3) {
            i++;
            MapMessage message = (MapMessage) consumer.receive();
            session.commit();

            // TODO something....
            System.out.println(message.getString("name"));
            System.out.println(message.getInt("int"));
            System.out.println("收到消息：" + new Date(message.getLong("count")));
        }

        session.close();
        connection.close();
    }
}