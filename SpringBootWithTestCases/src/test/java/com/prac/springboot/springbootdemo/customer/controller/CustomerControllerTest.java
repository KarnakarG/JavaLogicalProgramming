package com.prac.springboot.springbootdemo.customer.controller;

import com.prac.springboot.springbootdemo.customer.entity.Customer;
import com.prac.springboot.springbootdemo.customer.service.CustomerService;
import com.prac.springboot.springbootdemo.exception.CustomerNotFoundException;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
public class CustomerControllerTest {

    @InjectMocks
    CustomerController controller;

    @MockBean
    private CustomerService customerService;

    MockMvc mockMvc;

    @Before
    public void preTest() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();

    }

    @Test
    public void shouldRetrieveAllCustomers() throws Exception {
        Iterable<Customer> customerList = Arrays.asList((retriveCustomerMockData()));
        Mockito.when(
                customerService.retriveCustomers()).thenReturn(customerList);

        RequestBuilder requestBuilder = get("/customers");

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "[{\"id\":1001,\"name\":\"abc\",\"email\":\"abc@xyz.com\",\"date\":null}]";
        System.out.println(result.getResponse().getContentAsString());

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);

    }

    @Test
    public void shouldRetrieveCustomerById() throws Exception {
        Customer customerList = retriveCustomerMockData();
        Mockito.when(
                customerService.retrieveCustomerById(1001L)).thenReturn(Optional.of(customerList));
        mockMvc.perform(get("/customers/{id}", 1001L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.id", Matchers.is(1001)))
                .andExpect(jsonPath("$.name", is("abc")));
        verify(customerService, times(1)).retrieveCustomerById(1001L);
    }

    @Test(expected = CustomerNotFoundException.class)
    public void shouldNotRetrieveCustomerByIdNotFound() throws Exception {
        Customer customerList = retriveCustomerMockData();
        Mockito.when(
                customerService.retrieveCustomerById(1L)).thenReturn(Optional.of(customerList));
        RequestBuilder requestBuilder = get(
                "/customers/{id}", 2L);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        if (result.getResponse().getContentAsString().equals("")) {
            throw new CustomerNotFoundException("Customer Not found");
        }
    }


    @Test
    public void shouldDeleteCustomerById() throws Exception {
        Customer customer = retriveCustomerMockData();
        Mockito.when(
                customerService.retrieveCustomerById(1001L)).thenReturn(Optional.of(customer));

        mockMvc.perform(
                delete("/customers/{id}", 1001L))
                .andExpect(status().isNoContent());

        verify(customerService, times(1)).deleteCustomer(customer.getId());
    }

    @Test
    public void shouldNotDeleteCustomerByIdInvalid() throws Exception {
        Customer customer = retriveCustomerMockData();
        Mockito.when(
                customerService.retrieveCustomerById(1001L)).thenReturn(Optional.of(customer));

        mockMvc.perform(
                delete("/customers/{id}", 1001L))
                .andExpect(status().isNoContent());

        verify(customerService, times(1)).deleteCustomer(customer.getId());
    }

    @Test
    public void shouldRetrieveAllCustomersNewWay() throws Exception {
        Iterable<Customer> customerList = Arrays.asList((retriveCustomerMockData()));

        Mockito.when(
                customerService.retriveCustomers()).thenReturn(customerList);

        MvcResult results = mockMvc.perform(MockMvcRequestBuilders.get("/customers").accept(MediaType.APPLICATION_JSON))
                .andReturn();
        System.out.println(results.getResponse());
        verify(customerService).retriveCustomers();

    }

    private Customer retriveCustomerMockData() {
        return new Customer(1001L, "abc", "abc@xyz.com", null);
    }
}
