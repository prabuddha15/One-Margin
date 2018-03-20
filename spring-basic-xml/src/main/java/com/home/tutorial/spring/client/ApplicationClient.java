package com.home.tutorial.spring.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.home.tutorial.spring.service.CustomerService;
import com.home.tutorial.spring.service.CustomerServiceImpl;

public class ApplicationClient {

	public static void main(String[] args) {
		//CustomerService service = new CustomerServiceImpl();
		
		@SuppressWarnings("resource")
		ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerService service = context.getBean("customerService", CustomerService.class);
		
		System.out.println(service.findAll().get(0).getFirstName());
	}
}
