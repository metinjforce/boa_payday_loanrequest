package tr.com.jforce.controller;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.com.jforce.model.CustomerInfo;
import tr.com.jforce.model.Income;

@RestController
public class CustomerController {
	
	@PostMapping(value = "/mockKYCInformation")
	public ResponseEntity<CustomerInfo> getCustomerInfo() {
		
		CustomerInfo customerInfo = new CustomerInfo();
		customerInfo.setAddress("Customer address");
		customerInfo.setLastEmployerName("Customer lastEmploerName");
		customerInfo.setStartDate(new Date());
		
		return ResponseEntity.ok(customerInfo);
	}
	
	@PostMapping(value = "/mockIncomeInformation")
	public ResponseEntity<Income> incomeInformation() {
		
		Income income = new Income();
		income.setCustomerId(Long.valueOf(1234567890));
		income.setIncome(BigDecimal.valueOf(10000.00));

		return ResponseEntity.ok(income);
	}

}
