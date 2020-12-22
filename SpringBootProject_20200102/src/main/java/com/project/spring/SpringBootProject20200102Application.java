package com.project.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication()
public class SpringBootProject20200102Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProject20200102Application.class, args);
	}

}
