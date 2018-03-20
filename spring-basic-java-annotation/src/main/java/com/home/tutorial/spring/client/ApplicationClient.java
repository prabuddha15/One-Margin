package com.home.tutorial.spring.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.home.tutorial.spring.config.ApplicationConfig;
import com.home.tutorial.spring.service.CustomerService;

public class ApplicationClient {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext appContext=new AnnotationConfigApplicationContext(ApplicationConfig.class);
		CustomerService service = appContext.getBean("customerService",CustomerService.class);
		System.out.println(service.findAll().get(0).getFirstName());
	}
}
