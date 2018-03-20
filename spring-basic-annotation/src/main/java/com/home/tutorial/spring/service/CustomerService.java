package com.home.tutorial.spring.service;

import java.util.List;

import com.home.tutorial.spring.model.Customer;

public interface CustomerService {

	public abstract List<Customer> findAll();

}