package com.flexone.lakeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LakeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LakeServiceApplication.class, args);
	}

}
