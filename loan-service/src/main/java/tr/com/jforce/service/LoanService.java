package tr.com.jforce.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import tr.com.jforce.model.ApplyLoanRequest;

public interface LoanService {

	public  void applyForLoan(ApplyLoanRequest applyLoanRequest) throws Exception;
	
}
