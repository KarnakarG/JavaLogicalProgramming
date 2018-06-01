package com.prac.springboot.springbootdemo.customer.service;

import com.prac.springboot.springbootdemo.customer.entity.Customer;
import com.prac.springboot.springbootdemo.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;


@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer) {
        customer.setDate(new Date());
        return customerRepository.save(customer);
    }

    public Iterable<Customer> retriveCustomers() {
        return customerRepository.findAll();
    }

    public Customer updateCustomerName(Customer customer) {

        return customerRepository.save(customer);

    }

    public Optional<Customer> retrieveCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public void deleteCustomer(Long id) {

        customerRepository.deleteById(id);
    }

}
