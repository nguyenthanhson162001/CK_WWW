package com.spring.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.demo.entity.Customer;
import com.spring.demo.entity.Factory;

@Repository
public class DaoImpl implements Dao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createNativeQuery("select * from customer", Customer.class).getResultList();
	}

	@Override
	@Transactional
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		 return sessionFactory.getCurrentSession().get(Customer.class,id);
	}

	@Override
	@Transactional
	public boolean deleteCustromer(int id) {
		// TODO Auto-generated method stub
		try {
			 sessionFactory.getCurrentSession().delete(new Customer(id));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			// TODO: handle exception
		}
		return true;
	}

	@Override
	@Transactional
	public boolean addOrUpdateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		try {
			 sessionFactory.getCurrentSession().saveOrUpdate(customer);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			// TODO: handle exception
		}
		return true;
	}
	@Override
	@Transactional
	public List<Factory> getFactories() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createNativeQuery("select * from factory", Factory.class).getResultList();
	}

}
