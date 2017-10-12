package com.lord.rahl.controllers.web;

import com.lord.rahl.domain.Merchant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by lordrahl on 12/10/2017.
 */
@Controller
public class AdminController {

    @GetMapping("/admin/landing")
    public String landing(){
        return "admin/landing";
    }

    @GetMapping("/admin/merchant/create")
    public String createMerchant(Model model){
        model.addAttribute("merchant", new Merchant());
        return "admin/newMerchant";
    }

}
