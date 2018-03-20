package com.home.tutorial.spring.repository;

import java.util.List;

import com.home.tutorial.spring.model.Customer;

public interface CustomerRepository {

	public abstract List<Customer> findAll();

}