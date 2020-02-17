package tr.com.jforce.boa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = { "tr.com.*" })
@EntityScan(basePackages = {"tr.com.*"})
@EnableEurekaClient


@EnableFeignClients
@EnableDiscoveryClient

public class DecisionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DecisionServiceApplication.class, args);
	}

}
