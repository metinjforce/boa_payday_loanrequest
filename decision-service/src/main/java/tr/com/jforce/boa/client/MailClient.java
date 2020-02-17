package tr.com.jforce.boa.client;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import tr.com.jforce.boa.model.SendMailRequest;
import tr.com.jforce.boa.model.SendMailResponse;

@FeignClient(name = "mail-service")
@RibbonClient(name="mail-service")
@Component
public interface MailClient {
	
	
	@PostMapping("/rest/sendMail")
	SendMailResponse sendMail(SendMailRequest sendMailRequest);

}
