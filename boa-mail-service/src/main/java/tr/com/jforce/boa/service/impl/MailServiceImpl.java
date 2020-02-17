package tr.com.jforce.boa.service.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import tr.com.jforce.boa.model.SendMailRequest;
import tr.com.jforce.boa.service.MailUtilService;


@Service

public class MailServiceImpl implements MailUtilService {
	
	@Autowired
    private JavaMailSender mailSender;
	
    public SimpleMailMessage templateForSimpleMessage() {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("Apply For Loan Result");
        return simpleMailMessage;
    }
    
    @Override
    public void sendActivationMail(SendMailRequest sendMailRequest) throws MessagingException {
        SimpleMailMessage simpleMailMessage = templateForSimpleMessage();
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setText("Your apply for loan accepted");
            
            /*
            mimeMessageHelper.setText("User Name: " + sendMailRequest.getFullName() + "\r\n"+ 
            						  "Date of Birth: " + sendMailRequest.getDateOfBirth() + "\r\n"+  
            						  "Gender: " + sendMailRequest.getGender() + "\r\n"+  
            						  "Phone Number: " + sendMailRequest.getPhoneNumber() + "\r\n"+  
            						  "Account Number: " + sendMailRequest.getAccountNumber() + "\r\n"+  
            						  "Account Type: " + sendMailRequest.getAccountType());
            */
            mimeMessageHelper.setTo(sendMailRequest.getEmailAddress());
            mimeMessage.setSubject(simpleMailMessage.getSubject());
            mailSender.send(mimeMessage);

        } catch (MessagingException messagingException) {
          throw messagingException;
        }
    }

}
