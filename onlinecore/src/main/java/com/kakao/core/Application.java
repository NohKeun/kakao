package com.kakao.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.kakao.api", "com.kakao.core"})
public class Application {

	public static void main(String[] args) {
		System.out.println("hello");

		SpringApplication.run(Application.class, args);
	}

}
