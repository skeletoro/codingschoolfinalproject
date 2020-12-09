package com.brickbuster;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan()
@SpringBootApplication
public class BrickbusterApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrickbusterApplication.class, args);
	}

}
