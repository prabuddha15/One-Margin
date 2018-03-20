package com.home.tutorial.spring.service;

import java.util.List;

import com.home.tutorial.spring.model.Customer;
import com.home.tutorial.spring.repository.CustomerRepository;

public interface CustomerService {

	//public void setCustomerRepository(CustomerRepository customerRepository);
	public List<Customer> findAll();

}