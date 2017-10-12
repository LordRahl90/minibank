package com.lord.rahl.controllers.rest;

import com.lord.rahl.domain.Merchant;
import com.lord.rahl.service.MerchantService;
import com.lord.rahl.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lordrahl on 12/10/2017.
 */
@RestController
public class MerchantAccessRestController {

    MerchantService merchantService;

    @Autowired
    public void setMerchantService(MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @PostMapping("/merchant/login")
    @ResponseBody
    public Map<String, String> login(Merchant merchant){
        HashMap<String, String> map=Utility.response("success","Successful process","Message");

        System.out.println(map.toString());
        return map;
    }
}
