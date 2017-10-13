package com.lord.rahl.controllers.web;

import com.lord.rahl.bean.CurrentMerchant;
import com.lord.rahl.domain.Customer;
import com.lord.rahl.domain.Merchant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lordrahl on 13/10/2017.
 */
@Controller
@RequestMapping("merchant")
public class MerchantController {

    private static final Logger logger= LoggerFactory.getLogger(MerchantController.class);

    @GetMapping("login")
    public String login(Model model) {
        model.addAttribute("merchant", new Merchant());
        return "merchants/login";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CurrentMerchant currentMerchant = (CurrentMerchant) auth.getPrincipal();
        model.addAttribute("merchant", currentMerchant.getMerchant());
        return "merchants/dashboard";
    }

    @GetMapping("/new-customer")
    public String newCustomer(Model model) {
        model.addAttribute("customer",new Customer());
        return "merchants/newCustomer";
    }

    @GetMapping("/customers")
    public String getCustomers(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CurrentMerchant currentMerchant = (CurrentMerchant) auth.getPrincipal();
        Merchant merchant=currentMerchant.getMerchant();
        logger.info(merchant.getCustomers().toString());
        model.addAttribute("customers",merchant.getCustomers());
        return "merchants/customerList";
    }
}
