package tr.com.jforce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.com.jforce.model.ApplyLoanRequest;
import tr.com.jforce.model.Loan;
import tr.com.jforce.service.LoanService;
import tr.com.jforce.service.RabbitMQSender;

@Service
public class LoanServiceImpl implements LoanService{
	
	@Autowired
	RabbitMQSender rabbitMQSender;
	
	@Override
	public void applyForLoan(ApplyLoanRequest applyLoanRequest) throws Exception{
		rabbitMQSender.sendApplyForLoanMessage(applyLoanRequest);
		
		return;
	}

}
