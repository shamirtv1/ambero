package com.ambero.sectorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SectorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SectorServiceApplication.class, args);
	}

}
