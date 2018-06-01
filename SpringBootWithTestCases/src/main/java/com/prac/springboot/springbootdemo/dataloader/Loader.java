package com.prac.springboot.springbootdemo.dataloader;

import com.prac.springboot.springbootdemo.customer.entity.Customer;
import com.prac.springboot.springbootdemo.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Loader {

    @Autowired
    CustomerRepository repository;

    @PostConstruct
    public void load() {

        List<Customer> custometList = getCustomerList();
        repository.saveAll(custometList);
    }

    public static List<Customer> getCustomerList() {

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Rama", "Rama@xyz.com"));
        customers.add(new Customer("Ranga", "Ranga@xyz.com"));
        customers.add(new Customer("Ajay", "Ajay@xyz.com"));
        return customers;
    }
}
