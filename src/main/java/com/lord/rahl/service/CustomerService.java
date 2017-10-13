package com.lord.rahl.service;

import com.lord.rahl.domain.Customer;

import java.util.List;

/**
 * Created by lordrahl on 13/10/2017.
 */
public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomerById(Long id);
    Customer getCustomerByEmail(String email);
    String saveCustomer(Customer customer);
    void removeCustomer(Long id);
}
