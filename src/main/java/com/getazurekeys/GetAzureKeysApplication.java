package com.getazurekeys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.getazurekeys.UserRepository")
public class GetAzureKeysApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetAzureKeysApplication.class, args);
	}

}
