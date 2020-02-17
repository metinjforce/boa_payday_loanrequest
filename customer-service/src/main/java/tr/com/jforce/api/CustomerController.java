package tr.com.jforce.api;

import java.math.BigDecimal;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import tr.com.jforce.model.Account;
import tr.com.jforce.model.Customer;
import tr.com.jforce.model.CustomerInfo;
import tr.com.jforce.model.CustomerRepository;
import tr.com.jforce.model.Income;
import tr.com.jforce.model.IncomeRepository;



@RestController
public class CustomerController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private IncomeRepository incomeRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

	@GetMapping("rest/getKYCInformation")
	public ResponseEntity<CustomerInfo> getCustomerData() {
		
		String userPass = "user1:user1";
		byte[] credentials = userPass.getBytes();
		byte[] base64CredsBytes = Base64.getEncoder().encode(credentials);
		String base64Creds = new String(base64CredsBytes);
		
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

		MultiValueMap<String, String> authHeaders = new LinkedMultiValueMap<>();
	    authHeaders.add("Content-Type", "application/json");
	    authHeaders.add("Authorization", "Basic " + base64Creds);
		
        HttpEntity httpEntity = new HttpEntity(authHeaders);

		ResponseEntity<CustomerInfo> customerInfo = restTemplate.postForEntity("http://localhost:9002/mockKYCInformation", httpEntity, CustomerInfo.class);

		LOGGER.info("Customer Info:" + customerInfo.getBody());
		
		return ResponseEntity.ok(customerInfo.getBody());
	}
	
	@GetMapping("rest/getIncomeInformation/{customerId}")
	public ResponseEntity<Customer> getIncomeInformation(@PathVariable String customerId) {
        Boolean isCached = false;
        
    	String userPass = "user1:user1";
		byte[] credentials = userPass.getBytes();
		byte[] base64CredsBytes = Base64.getEncoder().encode(credentials);
		String base64Creds = new String(base64CredsBytes);
		
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

		MultiValueMap<String, String> authHeaders = new LinkedMultiValueMap<>();
	    authHeaders.add("Content-Type", "application/json");
	    authHeaders.add("Authorization", "Basic " + base64Creds);
		
        HttpEntity httpEntity = new HttpEntity(authHeaders);
	
        try {
			isCached = checkCache(customerId);
			LOGGER.info("Check Cache:" + isCached);
			if (!isCached) {
				ResponseEntity<Income> income = restTemplate.postForEntity("http://localhost:9002/mockIncomeInformation", httpEntity, Income.class);
				Customer cacheCustomer = new Customer(1L, customerId, "Metin", BigDecimal.valueOf(20000));
				cacheCustomerData(cacheCustomer);
				//cacheCustomerData();
			}
		}
		catch(Exception e) {
			LOGGER.info(e.getMessage());
		}

        Customer customerData = getCachedData(customerId);
		
		ResponseEntity<Income> income = restTemplate.postForEntity("http://localhost:9002/mockIncomeInformation", httpEntity, Income.class);

		LOGGER.info("Income Info:" + income.getBody());
		
		return ResponseEntity.ok(customerData);
	}
	
	public Boolean checkCache(String customerId) {
		
		try {
			Customer customer1 = customerRepository.findByExternalId(customerId);
			if (customer1 == null) {
				return false;
			}
		} 
		catch(Exception exception) {
			LOGGER.error(exception.getMessage());
			throw exception;
		}
        
		return true;
	}
	
	public void cacheCustomerData(Customer customer) {
		
		Customer cacheCustomer = new Customer(1L, customer.getExternalId(), "Metin San", BigDecimal.valueOf(10000));
		
		//Customer customer = new Customer(1L, "999999999", "Metin San", BigDecimal.valueOf(10000));
		customerRepository.save(cacheCustomer);
	
	}
	
	public Customer getCachedData(String customerId) {
  
			       Customer cachedCustomer = customerRepository.findByExternalId(customerId);
			       LOGGER.info("Cached Customer Info: " + cachedCustomer.getName());
			       
			       return cachedCustomer;
				
	}
	
	public void cacheData(CustomerInfo customer) {
		
		/*
		RedisClient redisClient = RedisClient
				  .create("redis://password@localhost:6379/");
				StatefulRedisConnection<String, String> connection
				 = redisClient.connect();
				*/
				
		/*
				 Customer customer = new Customer(1L, "80010121099", "Metin San");
			        customer.addAccount(new Account(1L, "1234567890", 2000));
			        customer.addAccount(new Account(2L, "1234567891", 4000));
			        customer.addAccount(new Account(3L, "1234567892", 6000));
			        customerRepository.save(customer);
			       */ 
			        
			       // Customer customer1 = customerRepository.findByExternalId("80010121098");
			      //  LOGGER.info(customer1.getName());
				
	}
}
