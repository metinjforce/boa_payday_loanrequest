package tr.com.jforce.boa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import tr.com.jforce.boa.model.ApplyLoanRequest;
import tr.com.jforce.boa.service.RabbitMQSender;
import tr.com.jforce.boa.service.RiskAnalysisService;

@RestController
@Service
@Component
public class RiskAnalysisServiceImpl implements RiskAnalysisService{

	@Autowired
	RabbitMQSender rabbitMQSender;
	
	
	
	@Override
	public void analyzeRisk(ApplyLoanRequest applyLoanRequest) throws Exception {
		Thread.sleep(300000);	
	}

	


}
