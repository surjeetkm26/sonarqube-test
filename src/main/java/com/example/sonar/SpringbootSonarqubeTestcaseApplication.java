package com.example.sonar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sonar.controller"})
public class SpringbootSonarqubeTestcaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSonarqubeTestcaseApplication.class, args);
	}

}
