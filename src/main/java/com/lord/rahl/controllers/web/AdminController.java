package com.lord.rahl.controllers.web;

import com.lord.rahl.domain.Merchant;
import com.lord.rahl.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by lordrahl on 12/10/2017.
 */
@Controller
public class AdminController {

    MerchantService merchantService;

    @Autowired
    public void setMerchantService(MerchantService merchantService) {
        this.merchantService = merchantService;
    }


    @GetMapping("/admin/landing")
    public String landing(){
        return "admin/landing";
    }

    @GetMapping("/admin/merchant/create")
    public String createMerchant(Model model){
        model.addAttribute("merchant", new Merchant());
        return "admin/newMerchant";
    }

    @GetMapping("/admin/merchant/list")
    public String list(Model model){
        model.addAttribute("merchants",merchantService.getAllMerchants());
        return "admin/list";
    }

}
