package com.attendancemonitoring.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = { "com.attendancemonitoring.repository" })
@EntityScan(basePackages = { "com.attendancemonitoring.entity" })
@SpringBootApplication(scanBasePackages = { "com.attendancemonitoring" })
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

}
