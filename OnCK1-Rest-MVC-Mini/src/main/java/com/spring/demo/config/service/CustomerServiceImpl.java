package com.spring.demo.config.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spring.demo.entity.Customer;
import com.spring.demo.entity.Factory;

@Service
public class CustomerServiceImpl implements CustomerService {

	private RestTemplate restTemplate;
	private String crmRestUrl;

	public CustomerServiceImpl(RestTemplate restTemplate, @Value("${crm.rest.url}") String url) {
		this.restTemplate = restTemplate;
		crmRestUrl = url;
	}

	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		System.out.println(crmRestUrl);
		ResponseEntity<List<Customer>> responseEntity = restTemplate.exchange(crmRestUrl+"customers", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Customer>>() {
				});
				
		return responseEntity.getBody();
	}

	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		return restTemplate.getForObject(crmRestUrl + "customers/" + id, Customer.class);
	}

	public boolean deleteCustromer(int id) {
		// TODO Auto-generated method stub
		restTemplate.delete(crmRestUrl + "customers/" + id);
		return false;
	}

	public boolean addOrUpdateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		if (customer.getId() == 0) {
			System.out.println("add");
			restTemplate.postForEntity(crmRestUrl + "customers/add", customer, String.class);
		} else {

			System.out.println("update");
			restTemplate.put(crmRestUrl + "customers/update", customer);
		}
		return false;
	}

	public List<Factory> getFactories() {
		// TODO Auto-generated method stub
	return restTemplate.exchange(crmRestUrl+"factories", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Factory>>() {
				}).getBody();
	
	}

}
