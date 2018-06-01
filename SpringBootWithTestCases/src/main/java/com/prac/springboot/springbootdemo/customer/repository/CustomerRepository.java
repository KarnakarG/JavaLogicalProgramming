package com.prac.springboot.springbootdemo.customer.repository;


import com.prac.springboot.springbootdemo.customer.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
