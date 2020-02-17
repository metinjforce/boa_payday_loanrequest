package tr.com.jforce.client;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import tr.com.jforce.model.Employee;
import tr.com.jforce.model.Customer;
import tr.com.jforce.model.CustomerInfo;
import tr.com.jforce.model.Income;

@FeignClient(name="customer-service")
@RibbonClient(name="customer-service")
public interface CustomerClient {

	@GetMapping("rest/getKYCInformation")
	ResponseEntity<CustomerInfo> getCustomerData();
	
	@GetMapping("rest/getIncomeInformation/{customerId}")
	ResponseEntity<Customer> getIncomeInformation(@PathVariable String customerId);
}
