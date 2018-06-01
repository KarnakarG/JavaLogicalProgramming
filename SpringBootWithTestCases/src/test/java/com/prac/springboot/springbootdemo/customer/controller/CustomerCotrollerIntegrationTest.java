package com.prac.springboot.springbootdemo.customer.controller;

import com.prac.springboot.springbootdemo.SpringbootDemoApplication;
import com.prac.springboot.springbootdemo.customer.entity.Customer;
import com.prac.springboot.springbootdemo.customer.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;
import java.util.Optional;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = SpringbootDemoApplication.class
)
@AutoConfigureMockMvc
public class CustomerCotrollerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    CustomerRepository repository;

    @Test
    public void shouldCreateCustomers() throws Exception {
        Customer customer = new Customer("abc", "abc@xyz.com");

        ResponseEntity<Customer> responseEntity =
                restTemplate.postForEntity("/customers", customer, Customer.class);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }

    @Test
    public void shouldRetriveCustomersById() throws Exception {
        ResponseEntity<Customer> responseEntity =
                restTemplate.getForEntity("/customers/{name}", Customer.class, 1L);
        Customer customer = responseEntity.getBody();
        System.out.println(customer.getId());
    }

    @Test
    public void shouldDeleteCustomers() throws Exception {

        Customer customer = new Customer("abcdefgh", "abcefgh@xyz.com");
        customer = repository.save(customer);

        restTemplate.delete("/customers/" + customer.getId(), Collections.EMPTY_MAP);
        Optional<Customer> customer1 = repository.findById(customer.getId());
        assertFalse(customer1.isPresent());

    }

    @Test
    public void shouldUpdateCustomers() throws Exception {

        Customer customer = new Customer("abcd", "abcefgh@xyz.com");
        customer = repository.save(customer);
        Long id = customer.getId();
        HttpEntity<Customer> httpEntity = new HttpEntity<>(new Customer("abcdefgh", "abcefgh@xyz.com"));
        ResponseEntity<Customer> responseEntity = restTemplate.exchange("/customers/" + id,
                HttpMethod.PUT,
                httpEntity,
                Customer.class);
        Customer updatedCustomer = responseEntity.getBody();
        assertNotEquals(customer.getName(), updatedCustomer.getName());
        assertEquals("abcdefgh", updatedCustomer.getName());

    }

    @Test
    public void shouldRetrieveAllCustomersNewWay() throws Exception {
        MvcResult results = mockMvc.perform(MockMvcRequestBuilders.get("/customers").accept(MediaType.APPLICATION_JSON))
                .andReturn();
        System.out.println(results.getResponse().getContentAsString());
    }


}