package com.lord.rahl.controllers.web;

import com.lord.rahl.domain.Merchant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by lordrahl on 12/10/2017.
 */
@Controller
public class MerchantAccessController {

    @GetMapping("/merchant/login")
    public String login(Model model){
        model.addAttribute("merchant",new Merchant());
        return "merchants/login";
    }


}
