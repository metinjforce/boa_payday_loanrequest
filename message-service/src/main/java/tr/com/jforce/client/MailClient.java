package tr.com.jforce.client;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import tr.com.jforce.model.SendMailRequest;
import tr.com.jforce.model.SendMailResponse;

@FeignClient(name = "mail-service")
@RibbonClient(name="mail-service")
@Component
public interface MailClient {
	
	
	@PostMapping("/rest/sendMail")
	SendMailResponse sendMail(SendMailRequest sendMailRequest);

}
