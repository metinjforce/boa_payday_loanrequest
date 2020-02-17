package tr.com.jforce.boa.service;

import javax.mail.MessagingException;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import tr.com.jforce.boa.model.SendMailRequest;

public interface MailUtilService {
	
	public void sendActivationMail(SendMailRequest sendMailRequest) throws MessagingException;
}
