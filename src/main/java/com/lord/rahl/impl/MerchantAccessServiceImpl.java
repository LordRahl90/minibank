package com.lord.rahl.impl;

import com.lord.rahl.domain.Merchant;
import com.lord.rahl.service.MerchantAccessService;
import com.lord.rahl.service.MerchantService;
import com.lord.rahl.utility.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created by lordrahl on 12/10/2017.
 */
@Service
public class MerchantAccessServiceImpl implements MerchantAccessService {

    private MerchantService merchantService;
    private final Logger logger= LoggerFactory.getLogger(MerchantServiceImpl.class);

    @Autowired
    public void setMerchantService(MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @Override
    public HashMap<String, String> loginMerchant(String email, String password) {
        Merchant merchant=merchantService.getOneMerchant(email);

        if(merchant==null){
            logger.info("Merchant not found");
            return Utility.response("error","Merchant Not Found","Merchant Not Found");
//            return "Merchant not found";
        }

        logger.info(merchant.getEmail());

        return Utility.response("success","Merchant Found","Merchant has been found");
    }
}
