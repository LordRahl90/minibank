package com.lord.rahl.impl;

import com.lord.rahl.domain.Customer;
import com.lord.rahl.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by lordrahl on 13/10/2017.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private EntityManagerFactory emf;
    private static final Logger logger= LoggerFactory.getLogger(CustomerServiceImpl.class);

    @PersistenceUnit
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<Customer> getAllCustomers() {
        EntityManager em=emf.createEntityManager();
        Query query=em.createQuery("from customers",Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer getCustomerById(Long id) {
        EntityManager em=emf.createEntityManager();
        return em.find(Customer.class,id);
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        Customer customer=new Customer();
        EntityManager em=emf.createEntityManager();
        Query query=em.createQuery("select c from Customer c where email=:email");
        query.setParameter("email",email);

        List<?> list=query.getResultList();

        if(!list.isEmpty()){
            customer=(Customer) list.get(0);
        }

        return customer;
    }

    @Override
    public String saveCustomer(Customer customer) {
        EntityManager em=emf.createEntityManager();
        Customer newCustomer=new Customer();
        String result="";

        if(customer.getMerchant()==null){
            return "Merchant must be providere";
        }

        logger.debug("Customer merchant is "+customer.getMerchant());


        //lets check if this customer exists for this merchant before
        Query query=em.createQuery("select c from Customer c" +
                " where c.merchant=:merchant and (c.phone=:phone or c.email=:email)");
        query.setParameter("merchant",customer.getMerchant());
        query.setParameter("phone",customer.getPhone());
        query.setParameter("email",customer.getEmail());

        List<Customer> customers=query.getResultList();

        if(!customers.isEmpty()){
            //means this user exists
            result="Customer Exists for this user";
        }
        else{
            em.getTransaction().begin();
            try{
                 em.merge(customer);
                 em.getTransaction().commit();
                 result="Customer Account Created Successfully!";
            }
            catch (Exception ex){
                em.getTransaction().rollback();
                ex.printStackTrace();
            }
        }

        return result;
    }

    @Override
    public void removeCustomer(Long id) {

    }
}
