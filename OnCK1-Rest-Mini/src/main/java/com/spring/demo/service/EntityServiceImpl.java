package com.spring.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.demo.dao.Dao;
import com.spring.demo.entity.Customer;
import com.spring.demo.entity.Factory;

@Service
public class EntityServiceImpl implements EntityService {

	@Autowired 
	private Dao dao;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return dao.getCustomers();
	}

	@Override
	@Transactional
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		return dao.getCustomerById(id);
	}

	@Override
	@Transactional
	public boolean deleteCustromer(int id) {
		// TODO Auto-generated method stub
		return dao.deleteCustromer(id);
	}

	@Override
	@Transactional
	public boolean addOrUpdateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return dao.addOrUpdateCustomer(customer);
	}

	@Override
	@Transactional
	public List<Factory> getFactories() {
		// TODO Auto-generated method stub
		return dao.getFactories();
	}


}
