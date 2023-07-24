package com.will.hypertrophyadviceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class HypertrophyAdviceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HypertrophyAdviceServiceApplication.class, args);
	}

}
