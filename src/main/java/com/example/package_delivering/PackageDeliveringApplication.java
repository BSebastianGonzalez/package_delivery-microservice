package com.example.package_delivering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PackageDeliveringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PackageDeliveringApplication.class, args);
	}

}
