package com.example.telegram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.telegram")
public class TelegramApplication extends Throwable {

	public static void main(String[] args) {
		SpringApplication.run(TelegramApplication.class, args);
	}


}
