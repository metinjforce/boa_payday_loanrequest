package tr.com.jforce.client;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import tr.com.jforce.model.ApplyLoanRequest;
import tr.com.jforce.model.ApplyLoanResponse;

@FeignClient(name="decision-service")
@RibbonClient(name="decison-service")
public interface RiskClient {

	@PostMapping("/rest/analyzeRisk")
	ResponseEntity<ApplyLoanResponse> analyzeRisk(@RequestBody ApplyLoanRequest riskAnalysisRequest);
	
}
