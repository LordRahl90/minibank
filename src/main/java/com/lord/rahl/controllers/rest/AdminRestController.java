package com.lord.rahl.controllers.rest;

import com.lord.rahl.domain.Merchant;
import com.lord.rahl.impl.MerchantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lordrahl on 12/10/2017.
 */
@RestController
public class AdminRestController {

    private MerchantServiceImpl merchantService;

    @Autowired
    public void setMerchantService(MerchantServiceImpl merchantService) {
        this.merchantService = merchantService;
    }

    @PostMapping("/admin/merchant/create")
    public String createMerchant(Merchant merchant){
        System.out.println(merchant.getEmail());
        String result=merchantService.saveMerchant(merchant);
        return result;
    }
}
