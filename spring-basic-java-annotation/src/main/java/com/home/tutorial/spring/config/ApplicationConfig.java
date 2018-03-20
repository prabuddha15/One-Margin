package com.home.tutorial.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.home.tutorial.spring.repository.CustomerRepository;
import com.home.tutorial.spring.repository.HibernateCustomerRepositoryImpl;
import com.home.tutorial.spring.service.CustomerService;
import com.home.tutorial.spring.service.CustomerServiceImpl;

@Configuration
@ComponentScan({"com.home.tutorial.spring"})
public class ApplicationConfig {

	@Bean(name = "customerService")
	public CustomerService getCustomerService() {
		CustomerServiceImpl service = new CustomerServiceImpl();
		service.setCustomerRepository(getCustomerRepository());
		return service;
	}

	@Bean(name = "customerRepository")
	public CustomerRepository getCustomerRepository() {
		return new HibernateCustomerRepositoryImpl();
	}

}
