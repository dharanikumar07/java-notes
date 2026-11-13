package com.learning_basic.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AppApplication.class, args);
		Demo obj = context.getBean(Demo.class);
		obj.PrintCompile();
		obj.printAutowiredFunction();
	}
}