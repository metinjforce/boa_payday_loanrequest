package tr.com.jforce.client;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import tr.com.jforce.model.ApplyLoanRequest;
import tr.com.jforce.model.ApplyLoanResponse;
import tr.com.jforce.model.SendMailRequest;
import tr.com.jforce.model.SendMailResponse;

@FeignClient(name = "decision-service")
@RibbonClient(name="decision-service")
public interface DecisionClient {
	
	
	@PostMapping("/rest/analyzeRisk")
	ResponseEntity<ApplyLoanResponse> analyzeRisk(@RequestBody ApplyLoanRequest riskAnalysisRequest);

}
