package com.lord.rahl.impl;

import com.lord.rahl.domain.Merchant;
import com.lord.rahl.service.MerchantService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by lordrahl on 12/10/2017.
 */
@Service
public class MerchantServiceImpl implements MerchantService {

    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Iterable<Merchant> getAllMerchants() {
        EntityManager em=emf.createEntityManager();
        return em.createQuery("from Merchant", Merchant.class).getResultList();
    }

    @Override
    public Merchant getOneMerchant(Long id) {
        EntityManager em=emf.createEntityManager();
        return em.find(Merchant.class,id);
    }

    @Override
    public String saveMerchant(Merchant merchant) {
        EntityManager em=emf.createEntityManager();

        Query q1=em.createQuery("select m from Merchant m where m.email=:email or m.phone=:phone",Merchant.class);
        q1.setParameter("email",merchant.getEmail());
        q1.setParameter("phone",merchant.getPhone());

        List<Merchant> merchants=q1.getResultList();

        if(merchants.size()>0){
            System.out.println("Merchant Exists already");
            return "Merchant already Exist";
        }

        em.getTransaction().begin();
        try{
            Merchant newMerchant=em.merge(merchant);
            em.getTransaction().commit();
        }
        catch(Exception ex){
            em.getTransaction().rollback();
            ex.printStackTrace();
        }

        return "Merchant Account Created Successfully";
    }

    @Override
    public void removeMerchant(Long id) {
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
            em.remove(em.find(Merchant.class,id));
        em.getTransaction().commit();

        System.out.println("Merchant Removed Successfully");
    }
}
