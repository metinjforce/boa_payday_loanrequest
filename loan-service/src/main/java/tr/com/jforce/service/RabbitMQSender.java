package tr.com.jforce.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import tr.com.jforce.model.ApplyLoanRequest;
import tr.com.jforce.model.Employee;
import tr.com.jforce.model.Loan;

@Service
public class RabbitMQSender {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQSender.class);
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${jforce.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${jforce.rabbitmq.routingkey}")
	private String routingkey;	
	
	/*
	public void send(Customer customer) {
		amqpTemplate.convertAndSend(exchange, routingkey, customer);
		LOGGER.info("Send msg = " + customer);
	}
	*/
	
	public void sendApplyForLoanMessage(ApplyLoanRequest applyLoanRequest) {
		amqpTemplate.convertAndSend(exchange, routingkey, applyLoanRequest);
		LOGGER.info("Send Loan msg = " + applyLoanRequest);
	}

}
