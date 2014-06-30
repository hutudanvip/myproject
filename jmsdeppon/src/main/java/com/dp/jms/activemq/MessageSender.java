package com.dp.jms.activemq;

/*
 * xcch@cnic.cn
 * 消息发送者
 */
import java.util.Date;
import javax.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageSender {

     public static void main(String[] args) throws Exception {
    	 System.out.println("bit of JVM is "+System.getProperty("sun.arch.data.model"));

         //ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("failover:(tcp://primary:61616)?timeout=3000&startupMaxReconnectAttempts=1&maxReconnectAttempts=0");//failover:失效转移
         ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616?connectionTimeout=3000");

         Connection connection = connectionFactory.createConnection();
         //connection.setExceptionListener(new MyJmsException());
         connection.start();

         Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
         Destination destination = session.createQueue("my-queue");

         MessageProducer producer = session.createProducer(destination);
         MapMessage message = session.createMapMessage();
         message.setInt("int", 1);
         message.setString("name", "李四");
         Thread.sleep(1000);
         message.setLong("count", new Date().getTime());
         //通过消息生产者发出消息
         producer.send(message);
         for(int i=0; i<3; i++) {
         }
         session.commit();
         session.close();
         connection.close();
    } 
}
