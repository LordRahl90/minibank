package com.lord.rahl.service;

import com.lord.rahl.bean.CurrentMerchant;
import com.lord.rahl.domain.Merchant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by lordrahl on 13/10/2017.
 */
@Service
public class CurrentMerchantDetailsService implements UserDetailsService {

    @Autowired
    private MerchantService merchantService;

    private static final Logger logger= LoggerFactory.getLogger(CurrentMerchantDetailsService.class);

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        logger.debug("Authenticating user with email={}", email.replaceFirst("@.*", "@***"));
        Merchant merchant=merchantService.getOneMerchant(email);

        return new CurrentMerchant(merchant);
    }

}
