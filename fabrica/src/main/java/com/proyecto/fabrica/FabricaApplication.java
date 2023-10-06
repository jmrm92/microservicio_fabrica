package com.proyecto.fabrica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EntityScan (basePackages="com.proyecto.fabrica.model")
@SpringBootApplication(scanBasePackages = {"com.proyecto.fabrica.controller", "com.proyecto.fabrica.service"})
public class FabricaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FabricaApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
