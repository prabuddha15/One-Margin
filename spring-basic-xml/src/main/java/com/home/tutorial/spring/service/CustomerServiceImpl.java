package com.home.tutorial.spring.service;

import java.util.List;

import com.home.tutorial.spring.model.Customer;
import com.home.tutorial.spring.repository.CustomerRepository;
import com.home.tutorial.spring.repository.HibernateCustomerRepositoryImpl;

public class CustomerServiceImpl implements CustomerService {

	// Below way to create instance needs to be replaced by Spring
	private CustomerRepository customerRepository;

	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
}
