package com.project.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class SpringBootProject20200101Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProject20200101Application.class, args);
	}

}
