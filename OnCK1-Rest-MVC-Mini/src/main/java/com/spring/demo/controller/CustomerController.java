package com.spring.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.demo.config.service.CustomerService;
import com.spring.demo.entity.Customer;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	
	@GetMapping("/")
	public String listCustomer(Model model) {
			model.addAttribute("customers",customerService.getCustomers());
		return "list-customer";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		model.addAttribute("customer",new Customer());
		model.addAttribute("factories",  customerService.getFactories());
		return "customer-form";
	}
	@GetMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer ) {
		customerService.addOrUpdateCustomer(customer);
		return "redirect:/";
	}
	@GetMapping("/showformForUpdate")
	public String showformForUpdate(@RequestParam("customerId") int id, Model model) {
		model.addAttribute("customer", customerService.getCustomerById(id));
		model.addAttribute("factories",  customerService.getFactories());
		return "customer-form";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int id) {
		customerService.deleteCustromer(id);
		return  "redirect:/";
	}
}
