package com.lucasb.finalsd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FinalSdBloiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalSdBloiseApplication.class, args);
		System.out.println("Hello World!");
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
