package com.lord.rahl.impl;

import com.lord.rahl.domain.Merchant;
import com.lord.rahl.domain.Role;
import com.lord.rahl.service.MerchantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;

/**
 * Created by lordrahl on 12/10/2017.
 */
@Service
public class MerchantServiceImpl implements MerchantService {

    private EntityManagerFactory emf;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private static final Logger logger = LoggerFactory.getLogger(MerchantServiceImpl.class);


    @PersistenceUnit
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Iterable<Merchant> getAllMerchants() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Merchant", Merchant.class).getResultList();
    }

    @Override
    public Merchant getOneMerchant(Long id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Merchant.class, id);
    }

    @Override
    public Merchant getOneMerchant(String email) {
        Merchant merchant=new Merchant();
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select m from Merchant m where m.email=:email", Merchant.class);
        query.setParameter("email", email);

        List<?> list=query.getResultList();
        logger.debug("We reached here");
        if(!list.isEmpty()){
            merchant=(Merchant) list.get(0);
        }

        return merchant;
    }

    @Override
    public Merchant getOneMerchant(String email, String password) {
        Merchant merchant=new Merchant();
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select m from Merchant m where m.email=:email and m.password=:password",
                Merchant.class);
        query.setParameter("email", email);
        query.setParameter("password", password);

        List<?> list=query.getResultList();

        if(!list.isEmpty()){
            merchant=(Merchant) list.get(0);
        }

        return merchant;
    }

    @Override
    public String saveMerchant(Merchant merchant) {
        EntityManager em = emf.createEntityManager();

        Query q1 = em.createQuery("select m from Merchant m where m.email=:email or m.phone=:phone", Merchant.class);
        q1.setParameter("email", merchant.getEmail());
        q1.setParameter("phone", merchant.getPhone());

        List<Merchant> merchants = q1.getResultList();

        if (merchants.size() > 0) {
            System.out.println("Merchant Exists already");
            return "Merchant already Exist";
        }

        em.getTransaction().begin();
        try {
            System.out.println(merchant.getPassword());
            merchant.setPassword(passwordEncoder.encode(merchant.getPassword()));
            merchant.setRole(Role.MERCHANT);
            Merchant newMerchant = em.merge(merchant);
            em.getTransaction().commit();


        } catch (Exception ex) {
            em.getTransaction().rollback();
            ex.printStackTrace();
            return "An error occurred while creating the merchant";
        }
        return "Merchant Account Created Successfully";
    }

    @Override
    public void removeMerchant(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Merchant.class, id));
        em.getTransaction().commit();

        System.out.println("Merchant Removed Successfully");
    }
}
