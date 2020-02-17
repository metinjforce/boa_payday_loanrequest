package tr.com.jforce.api;

import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sun.org.slf4j.internal.Logger;

import tr.com.jforce.client.CustomerClient;
import tr.com.jforce.client.RiskClient;
import tr.com.jforce.model.ApplyLoanRequest;
import tr.com.jforce.model.ApplyLoanResponse;
import tr.com.jforce.model.Customer;
import tr.com.jforce.model.Employee;
import tr.com.jforce.model.CustomerInfo;
import tr.com.jforce.model.Income;
import tr.com.jforce.service.LoanService;
import tr.com.jforce.service.RabbitMQSender;

@RestController
public class LoanController {
	

	@Autowired
	private LoanService loanservice;
	
	@Autowired
	RabbitMQSender rabbitMQSender;
	
	@Autowired
	CustomerClient customerClient;
	
	@Autowired
	RiskClient riskClient;


	/*
	@GetMapping(value = "/producer")
	public String producer(@RequestParam("empName") String empName, @RequestParam("empId") String empId) {
		Customer customer=new Customer();
		try {
			customer.setEmpId(empId);
			customer.setEmpName(empName);
			rabbitMQSender.send(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	return "Message sent to the RabbitMQ Successfully";
	}
	
	*/
	
	@PostMapping(value = "rest/applyForLoan")
	public ResponseEntity<ApplyLoanResponse> applyForLoan(@RequestBody ApplyLoanRequest applyLoanRequest) {
		ApplyLoanResponse applyLoanResponse = new ApplyLoanResponse();
		try {
			CustomerInfo customer = customerClient.getCustomerData().getBody();
			Customer cachedCustomer = customerClient.getIncomeInformation(String.valueOf(applyLoanRequest.getCustomerId())).getBody();
			loanservice.applyForLoan(applyLoanRequest);
			//riskClient.analyzeRisk(applyLoanRequest);
			applyLoanResponse.setSuccess(true);
			applyLoanResponse.setMessage("Your application is succesfull");
		} catch (Exception exception) {
			exception.printStackTrace();
			applyLoanResponse.setSuccess(false);
			applyLoanResponse.setMessage("Your application is unsuccesfull. Please try again later");
		}
		
		return ResponseEntity.ok(applyLoanResponse);
	}
	





}