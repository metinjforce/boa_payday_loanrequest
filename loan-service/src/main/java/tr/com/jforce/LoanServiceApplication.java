package tr.com.jforce;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import com.rabbitmq.client.AMQP.Queue;
import com.rabbitmq.client.ConnectionFactory;
import com.sun.xml.internal.org.jvnet.staxex.NamespaceContextEx.Binding;

import tr.com.jforce.service.LoanService;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = { "tr.com.*" })
@EntityScan(basePackages = {"tr.com.*"})
@EnableEurekaClient
@EnableFeignClients
@EnableDiscoveryClient
public class LoanServiceApplication {
	 
	static final String topicExchangeName = "spring-boot-exchange";
	String queueName = "queue";
	static final String exchange = "exchange";


	public static void main(String[] args) {
		SpringApplication.run(LoanServiceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	/*
	@Bean
	public LoanService loanService() {
	    return new LoanService();
	}
	*/
	
	
	
	
	
}
