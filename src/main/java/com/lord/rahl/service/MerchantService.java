package com.lord.rahl.service;

import com.lord.rahl.domain.Merchant;

/**
 * Created by lordrahl on 12/10/2017.
 */
public interface MerchantService {
    Iterable<Merchant> getAllMerchants();
//    Merchant saveMerchant(Merchant merchant);
    Merchant getOneMerchant(Long id);
    String saveMerchant(Merchant merchant);
    void removeMerchant(Long id);
}
