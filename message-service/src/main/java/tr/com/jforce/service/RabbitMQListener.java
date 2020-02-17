package tr.com.jforce.service;

import java.math.BigDecimal;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import tr.com.jforce.client.DecisionClient;
import tr.com.jforce.client.MailClient;
import tr.com.jforce.model.ApplyLoanRequest;
import tr.com.jforce.model.RiskAnalysisResponse;
import tr.com.jforce.model.SendMailRequest;

@RestController
@Component
public class RabbitMQListener implements MessageListener {
	@Autowired
	MailClient mailClient;
	
	@Autowired
	DecisionClient decisionClient;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQListener.class);
	
	
	public void onMessage(Message message) {
		
        try {

			LOGGER.info("Consuming Message - " + new String(message.getBody()));
			JSONObject applyForLoanMessage=new JSONObject(new String((message.getBody())));
			String emailAddress = applyForLoanMessage.get("emailAddress").toString();
			String customerId = applyForLoanMessage.get("customerId").toString();

			ApplyLoanRequest applyLoanRequest = new ApplyLoanRequest();
			applyLoanRequest.setEmailAddress(emailAddress);
			applyLoanRequest.setCustomerId(Long.valueOf(customerId));

			decisionClient.analyzeRisk(applyLoanRequest);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
        
	}
	
	public RiskAnalysisResponse analyzeRisk() {
		RiskAnalysisResponse riskAnalysisResponse = new RiskAnalysisResponse();
		
		return riskAnalysisResponse;
	}
	
	public void sendMail() {
		LOGGER.info("send");
		MailSender mailSender = new MailSender();
		SendMailRequest sendMailRequest = new SendMailRequest();
		sendMailRequest.setEmailAddress("metin@jforce.com.tr");
		sendMailRequest.setFullName("Jforce Jforce");
		sendMailRequest.setAccountNumber("123");
		sendMailRequest.setAccountType("321");
		sendMailRequest.setDateOfBirth("2000-01-01");
		sendMailRequest.setGender("Male");
		sendMailRequest.setPhoneNumber("5555555555");
		mailClient.sendMail(sendMailRequest);
		//mailSender.sendMail();
	}
	
	

}
