package cn.xu.testActiveMQ.springactivemq.consumer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

public class AppConsumer {
	
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
	}
}
