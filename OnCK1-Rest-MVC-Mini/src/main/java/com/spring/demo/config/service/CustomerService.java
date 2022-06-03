package com.spring.demo.config.service;

import java.util.List;

import com.spring.demo.entity.Customer;
import com.spring.demo.entity.Factory;

public interface CustomerService {
	public List<Customer> getCustomers();
	public Customer getCustomerById(int id);
	public boolean deleteCustromer(int id);
	public boolean addOrUpdateCustomer(Customer customer);
	public List<Factory> getFactories();
}
