package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService{

	
	@Autowired
	private CustomerRepository customerRepository;
	
	  public List<Customer> getAllCustomers() { 
		  List<Customer> customers = new ArrayList<>();
		  customerRepository.findAll().forEach(customers::add);
		  return customers;
		  }
	  
	  public Customer findCustomerByID(Long id) {
		  return customerRepository.findOne(id);
	  }
    
	  
	  public Customer saveorUpdateCustomer(Customer customer) {
		  return customerRepository.save(customer);
	  }
}
