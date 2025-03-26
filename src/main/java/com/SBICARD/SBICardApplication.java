package com.SBICARD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling // Enable cron jobs
public class SBICardApplication {

	public static void main(String[] args) {
		SpringApplication.run(SBICardApplication.class, args);
		System.out.println("Started Successfully");

		System.out.println("Testing");
	}

}
