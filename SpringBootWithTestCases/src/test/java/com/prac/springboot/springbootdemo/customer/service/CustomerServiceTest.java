package com.prac.springboot.springbootdemo.customer.service;

import com.prac.springboot.springbootdemo.customer.entity.Customer;
import com.prac.springboot.springbootdemo.customer.repository.CustomerRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerService.class)
public class CustomerServiceTest {


    @Autowired
    MockMvc mockMvc;

    @InjectMocks
    CustomerService customerService;

    @MockBean
    CustomerRepository customerRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(customerService)
                .build();
    }

    @Test
    public void shouldReturnCustomerList() throws Exception {
        Iterable<Customer> taskList = Arrays.asList(retriveCustomerMockData());
        when(customerRepository.findAll()).thenReturn(taskList);
        Iterable<Customer> result = customerService.retriveCustomers();
        Assert.assertEquals(1, result.spliterator().getExactSizeIfKnown());
    }

    private Customer retriveCustomerMockData() {
        return new Customer(1001L, "abc", "abc@xyz.com", null);
    }

}
