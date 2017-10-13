package com.lord.rahl.service;

import java.util.HashMap;

/**
 * Created by lordrahl on 12/10/2017.
 */
public interface MerchantAccessService {
    HashMap<String, String> loginMerchant(String email, String password);
}
