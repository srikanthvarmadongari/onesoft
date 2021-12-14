package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan({"com.example.controller","com.example.dao","com.example.model"})

@SpringBootApplication
public class Testweb2Application {

	public static void main(String[] args) {
		SpringApplication.run(Testweb2Application.class, args);
	}

}
