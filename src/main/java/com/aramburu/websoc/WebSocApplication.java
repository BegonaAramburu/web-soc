package com.aramburu.websoc;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.aramburu.websoc.*")
@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
public class WebSocApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebSocApplication.class, args);
	}

	
}
