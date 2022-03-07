package com.bootcamp.tarea3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
public class Tarea3Application {

	public static void main(String[] args) {
		SpringApplication.run(Tarea3Application.class, args);
	}

}
