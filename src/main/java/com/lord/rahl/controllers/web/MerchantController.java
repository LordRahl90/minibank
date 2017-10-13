package com.lord.rahl.controllers.web;

import com.lord.rahl.bean.CurrentMerchant;
import com.lord.rahl.domain.Merchant;
import org.omg.CORBA.Current;
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

    @GetMapping("login")
    public String login(Model model){
        model.addAttribute("merchant",new Merchant());
        return "merchants/login";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model){
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        CurrentMerchant currentMerchant=(CurrentMerchant) auth.getPrincipal();
        System.out.println(auth.getDetails());
        System.out.println(currentMerchant.getUsername());
        return "merchants/dashboard";
    }
}
