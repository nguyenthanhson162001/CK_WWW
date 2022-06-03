package com.spring.demo.service;

import java.util.List;

import com.spring.demo.entity.Customer;
import com.spring.demo.entity.Factory;

public interface FactoryService {
	public List<Factory> getFactories();
	public Factory getFactory(int id);
	public boolean addOrUpdateFactory(Factory factory);
	
}
