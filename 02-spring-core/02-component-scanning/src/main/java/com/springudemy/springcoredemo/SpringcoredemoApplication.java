package com.springudemy.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
// Explicitly list base packages to scan
@SpringBootApplication(
		scanBasePackages = {"com.springudemy.springcoredemo",
							"com.springudemy.util"})
*/
@SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}
