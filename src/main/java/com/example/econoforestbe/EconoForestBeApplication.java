package com.example.econoforestbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@SpringBootApplication
public class EconoForestBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EconoForestBeApplication.class, args);
	}

}
