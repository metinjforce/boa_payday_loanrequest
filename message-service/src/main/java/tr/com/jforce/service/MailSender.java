package tr.com.jforce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.com.jforce.client.MailClient;
import tr.com.jforce.model.SendMailRequest;

@RestController
public class MailSender {
	
	@Autowired
	MailClient mailClient;
	

	@GetMapping (value = "/rest/send")
	public void sendMail() {
		try {
			
			SendMailRequest sendMailRequest = new SendMailRequest();
			sendMailRequest.setEmailAddress("metin@jforce.com.tr");
			sendMailRequest.setFullName("Jforce Jforce");
			sendMailRequest.setAccountNumber("123");
			sendMailRequest.setAccountType("321");
			sendMailRequest.setDateOfBirth("2000-01-01");
			sendMailRequest.setGender("Male");
			sendMailRequest.setPhoneNumber("5555555555");
			mailClient.sendMail(sendMailRequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
