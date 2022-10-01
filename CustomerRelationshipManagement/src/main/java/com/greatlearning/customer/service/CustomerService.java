package com.greatlearning.customer.service;

import java.util.List;

import com.greatlearning.customer.entity.Customer;

public interface CustomerService {

	public List<Customer> findAll();

	Customer findById(int id);

	public void save(Customer customer);

	public void deleteById(int theId);

	public List<Customer> searchBy(String first_name, String email);

}
