package cn.xu.testActiveMQ.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class AppConsumer {
	private static final String url = "tcp://192.168.16.140:61616";
	private static final String queueName = "queue-test";
	public static void main(String[] args) throws JMSException{
		//1.创建connectionfactory
		ConnectionFactory connectionFactory=new ActiveMQConnectionFactory(url);
		//2.创建conneciton
		 Connection connection =connectionFactory.createConnection();
		 //3.启动连接
		 connection.start();
		 //4.创建会话
		  Session  session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		  //5创建一个目标
		  Destination  destination =session.createQueue(queueName);
		  //6.创建一个生产者
		 MessageConsumer consumer = session.createConsumer(destination);
		//7.创建监听器
		 consumer.setMessageListener(new MessageListener(){
			 public void onMessage(Message message){
				 TextMessage textMessage = (TextMessage) message;
				 try {
					System.out.println("接受消息"+textMessage.getText());
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
		 });
		  //9。关闭连接
		 //connection.close();
	}
}
