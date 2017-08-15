package com.mango;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthorityApplication {
	private static Logger logger = Logger.getLogger(AuthorityApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AuthorityApplication.class, args);
		logger.info("SpringBoot start Success!");
	}
}
