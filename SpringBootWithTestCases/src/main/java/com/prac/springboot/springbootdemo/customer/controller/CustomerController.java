package com.prac.springboot.springbootdemo.customer.controller;

import com.prac.springboot.springbootdemo.customer.entity.Customer;
import com.prac.springboot.springbootdemo.customer.service.CustomerService;
import com.prac.springboot.springbootdemo.exception.CustomerNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("customers")
@Api(value = "Customer Resource", description = "Shows Customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @ApiOperation("Create Customer")
    @PostMapping
    public ResponseEntity<Object> createCustomer(@RequestBody Customer customer) {

        Customer cust = customerService.createCustomer(customer);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(cust.getId()).toUri();
        return ResponseEntity.created(location).build();

    }

    @GetMapping("/{id}")
    @ApiOperation("Retrive Customer")
    public ResponseEntity<?> retrieveCustomerById(@PathVariable("id") Long id) {
        Optional<Customer> customer = customerService.retrieveCustomerById(id);
        if (!customer.isPresent())
            throw new CustomerNotFoundException("Customer not found for id " + id);
        return new ResponseEntity<Customer>(customer.get(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update Customer")
    public ResponseEntity<?> updateCustomerName(@PathVariable Long id, @RequestBody Customer customer) {
        Optional<Customer> customerPresent = customerService.retrieveCustomerById(id);
        if (!customerPresent.isPresent())
            throw new CustomerNotFoundException("Customer not found for id " + id);
        Customer currentCustomer = customerPresent.get();
        currentCustomer.setName(customer.getName());
        currentCustomer = customerService.updateCustomerName(currentCustomer);
        return new ResponseEntity<Customer>(currentCustomer, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete Customer")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        Optional<Customer> customer = customerService.retrieveCustomerById(id);
        if (!customer.isPresent())
            throw new CustomerNotFoundException("Customer not found for id " + id);
        customerService.deleteCustomer(id);
        return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    @ApiOperation("Retrive Customers List")
    public ResponseEntity<Iterable<Customer>> retriveCustomer() {
        return new ResponseEntity<>(customerService.retriveCustomers(), HttpStatus.OK);
    }


}
