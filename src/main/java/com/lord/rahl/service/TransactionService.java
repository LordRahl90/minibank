package com.lord.rahl.service;


import java.util.List;

import com.lord.rahl.domain.Customer;
import com.lord.rahl.domain.Merchant;
import com.lord.rahl.domain.TransactionManager;

/**
 * Created by lordrahl on 13/10/2017.
 */
public interface TransactionService {
    List<TransactionManager> getAllTransactions();
    TransactionManager getTransactionById(Long id);

    List<TransactionManager> getCustomerTransaction(Customer customer);
    List<TransactionManager> getMerchantTransaction(Merchant merchant);
    List<TransactionManager> getMerchantAndCustomerTransaction(Merchant merchant, Customer customer);

    TransactionManager createTransaction(TransactionManager transactionManager);
    void removeTransaction(Long id);
}
