package com.lord.rahl.bean;

import com.lord.rahl.domain.Merchant;
import com.lord.rahl.domain.Role;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

/**
 * Created by lordrahl on 13/10/2017.
 */

public class CurrentMerchant extends User {

    private static final Long serialVersionUID=1L;
    private Merchant merchant;


    public CurrentMerchant(Merchant merchant){
        super(merchant.getEmail(),merchant.getPassword(), AuthorityUtils.createAuthorityList(merchant.getRole().toString()));
    }

    public Merchant getMerchant(){
        return merchant;
    }

    public Long getId(){
        return merchant.getId();
    }

    public Role getRole(){
        return merchant.getRole();
    }


    @Override
    public String toString(){
        return "CurrentMerchant{"+
                "Merchant="+merchant+"}"+super.toString();
    }
}
