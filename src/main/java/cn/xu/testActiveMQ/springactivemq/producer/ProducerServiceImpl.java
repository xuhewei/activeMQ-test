package cn.xu.testActiveMQ.springactivemq.producer;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class ProducerServiceImpl implements ProducerService {
	@Autowired
	JmsTemplate jmsTemplate;
	@Resource(name="queueDestionation")
	Destination destination;
	@Override
	public void sendMessage(String message) {
		// TODO Auto-generated method stub
		jmsTemplate.send(destination,new MessageCreator(){
			public Message createMessage(Session session) throws JMSException{
				TextMessage testMessage = session.createTextMessage(message);
				System.out.println("发送消息"+testMessage.getText());
			     return testMessage;
			}
		});
	}

}
