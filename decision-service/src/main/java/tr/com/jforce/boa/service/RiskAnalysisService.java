package tr.com.jforce.boa.service;

import javax.mail.MessagingException;

import tr.com.jforce.boa.model.ApplyLoanRequest;
import tr.com.jforce.boa.model.RiskAnalysisRequest;

public interface RiskAnalysisService {
	
	public void analyzeRisk(ApplyLoanRequest applyLoanRequest) throws Exception;


}
