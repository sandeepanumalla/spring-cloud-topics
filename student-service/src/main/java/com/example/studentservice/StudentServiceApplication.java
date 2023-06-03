package com.example.studentservice;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.reactive.function.client.WebClient;

@ComponentScan("com.example")
@EntityScan("com.example.entity")
@EnableJpaRepositories("com.example.repository")
@EnableFeignClients("com.example.feignclients")
@EnableDiscoveryClient
@SpringBootApplication
public class StudentServiceApplication {

	@Value("${address.service.url}")
	private String addressServiceUrl;

	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

	@Bean
	public WebClient webClient() {
		System.out.println(addressServiceUrl);
		WebClient webClient = WebClient.builder()
				.baseUrl(addressServiceUrl)
				.build();
		return webClient;
	}

}
