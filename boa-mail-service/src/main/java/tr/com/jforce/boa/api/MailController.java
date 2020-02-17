package tr.com.jforce.boa.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiModel;
import tr.com.jforce.boa.model.SendMailRequest;
import tr.com.jforce.boa.model.SendMailResponse;
import tr.com.jforce.boa.service.MailUtilService;

@RestController
@ApiModel(description = "Mail")
public class MailController extends BaseRestController {
	
	@Autowired 
	private MailUtilService mailUtilService;
	
	@PostMapping("/rest/sendMail")
	public ResponseEntity<SendMailResponse> sendMail(@RequestBody SendMailRequest sendMailRequest) {
	SendMailResponse sendMailResponse = new SendMailResponse();
		try {
		mailUtilService.sendActivationMail(sendMailRequest);
	}
	catch (Exception e) {
		sendMailResponse.setSuccess(false);
		sendMailResponse.setMessage("Sending e-mail failed!");
		return ResponseEntity.ok(sendMailResponse);
	}
	//Send mail
	sendMailResponse.setSuccess(true);
	sendMailResponse.setMessage("Your e-mail has been sent");
	return ResponseEntity.ok(sendMailResponse);
	}

}
