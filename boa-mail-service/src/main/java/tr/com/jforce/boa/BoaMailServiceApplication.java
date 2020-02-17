package tr.com.jforce.boa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;

import tr.com.jforce.boa.service.impl.MailServiceImpl;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = { "tr.com.*" })
@EntityScan(basePackages = {"tr.com.*"})
@EnableEurekaClient
public class BoaMailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoaMailServiceApplication.class, args);
	}

}
