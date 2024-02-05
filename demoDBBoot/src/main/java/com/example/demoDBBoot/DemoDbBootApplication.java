package com.example.demoDBBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class DemoDbBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoDbBootApplication.class, args);
	}
}
