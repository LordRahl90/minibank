package com.lord.rahl.controllers.rest;

import com.lord.rahl.bean.CurrentMerchant;
import com.lord.rahl.domain.Customer;
import com.lord.rahl.domain.Merchant;
import com.lord.rahl.domain.Role;
import com.lord.rahl.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lordrahl on 13/10/2017.
 */
@RestController
@RequestMapping("merchant")
public class MerchantRestController {

    private CustomerService customerService;
    private static final Logger logger= LoggerFactory.getLogger(MerchantRestController.class);

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/new-customer")
    public String newCustomer(Customer customer) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CurrentMerchant currentMerchant = (CurrentMerchant) auth.getPrincipal();
        Merchant merchant=currentMerchant.getMerchant();

        logger.info(merchant.toString());

        customer.setMerchant(merchant);
        customer.setRole(Role.CUSTOMER);
        return customerService.saveCustomer(customer);
    }

}
