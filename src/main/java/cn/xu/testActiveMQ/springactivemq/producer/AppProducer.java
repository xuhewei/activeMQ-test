package cn.xu.testActiveMQ.springactivemq.producer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

public class AppProducer {
	
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("producer.xml");
		ProducerService service = context.getBean(ProducerService.class);
		DefaultMessageListenerContainer aa =new DefaultMessageListenerContainer();
		for(int i=0;i<100;i++){
			service.sendMessage("test"+i);
		}
	}
}
