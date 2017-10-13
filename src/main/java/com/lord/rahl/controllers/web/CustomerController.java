package com.lord.rahl.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lordrahl on 13/10/2017.
 */
@Controller
@RequestMapping("customer")
public class CustomerController {

    @GetMapping("/login")
    public String login(){
        return "customer/login";
    }


    @GetMapping("/dashboard")
    public String dashboard(){
        return "customer/dashboard";
    }
}
