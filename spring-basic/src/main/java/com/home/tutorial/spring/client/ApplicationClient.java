package com.home.tutorial.spring.client;

import com.home.tutorial.spring.service.CustomerService;
import com.home.tutorial.spring.service.CustomerServiceImpl;

public class ApplicationClient {

	public static void main(String[] args) {
		CustomerService service = new CustomerServiceImpl();
		System.out.println(service.findAll().get(0).getFirstName());
	}
}
