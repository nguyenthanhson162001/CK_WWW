package com.spring.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.entity.Customer;
import com.spring.demo.entity.Factory;
import com.spring.demo.service.EntityService;

@RequestMapping("/api")
@RestController
public class RestAPIController {

	@Autowired
	private EntityService e;
	
	
	@GetMapping("/factories")
	public List<Factory> getfactorys(){
		return e.getFactories();
	}
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		return e.getCustomers();
	}
	@GetMapping("/customers/{customerId}")
	public Customer getCustomers(@PathVariable int customerId){
		return e.getCustomerById(customerId);
	}
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomers(@PathVariable int customerId){
		return e.deleteCustromer(customerId) ? "Delete success" : "Delete fail";
	}
	@PostMapping("/customers/add")
	public String addCustomers(@RequestBody Customer customer){
		return e.addOrUpdateCustomer(customer) ? "Save success" : "Save fail";
	}
	@PutMapping("/customers/update")
	public String updateCustomers(@RequestBody Customer customer){
		return e.addOrUpdateCustomer(customer) ? "Save success" : "Save fail";
	}
}
