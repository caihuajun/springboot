package com.forezp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringbootCacaheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCacaheApplication.class, args);
	}
}
