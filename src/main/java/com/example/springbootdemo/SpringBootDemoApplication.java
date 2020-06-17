package com.example.springbootdemo;

import com.example.springbootdemo.controller.GirlController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(SpringBootDemoApplication.class, args);
		System.out.println(configurableApplicationContext.getBean(GirlController.class));
	}

}
