package com.portfolio.melkhazen.chartercommunications;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableAutoConfiguration
public class CharterCommunicationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CharterCommunicationsApplication.class, args);
	}
}
