package tr.com.jforce.boa.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiModel;
import tr.com.jforce.boa.client.MailClient;
import tr.com.jforce.boa.model.ApplyLoanRequest;
import tr.com.jforce.boa.model.RiskAnalysisRequest;
import tr.com.jforce.boa.model.RiskAnalysisResponse;
import tr.com.jforce.boa.model.SendMailRequest;
import tr.com.jforce.boa.service.RiskAnalysisService;


@RestController
@Component
@ApiModel(description = "Decision")
public class DecisionController extends BaseRestController {
	private static final Logger LOGGER = LoggerFactory.getLogger(DecisionController.class);

	@Autowired 
	private RiskAnalysisService riskAnalysisService;
	
	@Autowired
	MailClient mailClient;
	
	@PostMapping("/rest/analyzeRisk")
	public ResponseEntity<RiskAnalysisResponse> analyzeRisk(@RequestBody ApplyLoanRequest riskAnalysisRequest) {
	RiskAnalysisResponse sendMailResponse = new RiskAnalysisResponse();
		try {
		LOGGER.info("Risk Analysis started");
		riskAnalysisService.analyzeRisk(riskAnalysisRequest);
		LOGGER.info("Risk Analysis finished");
		SendMailRequest sendMailRequest = new SendMailRequest();
		sendMailRequest.setEmailAddress(riskAnalysisRequest.getEmailAddress());
		mailClient.sendMail(sendMailRequest);
		LOGGER.info("Mail is sent");
	}
	catch (Exception e) {
		sendMailResponse.setSuccess(false);
		sendMailResponse.setMessage("Risk service failed!");
		return ResponseEntity.ok(sendMailResponse);
	}

	sendMailResponse.setSuccess(true);
	sendMailResponse.setMessage("Risk is beeing calculated");
	return ResponseEntity.ok(sendMailResponse);
	}

}
