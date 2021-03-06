package com.lord.rahl.domain;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.List;

/**
 * Created by lordrahl on 12/10/2017.
 */
@Entity
@Table(name="customers")
public class Customer implements DomainObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Integer version;
    private String fullname;
    private String phone;
    private String address;
    private String email;

    @ManyToOne(cascade = CascadeType.ALL)
    private Merchant merchant;

    @OneToMany(mappedBy = "customer")
    List<TransactionManager> transactions;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created=new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date updated=new Date();

    @Enumerated(EnumType.STRING)
    Role role;

    @Override
    public void setId(Long id) {

    }

    @Override
    public Long getId() {
        return null;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<TransactionManager> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionManager> transactions) {
        this.transactions = transactions;
    }

    @Override
    public Date getCreated() {
        return created;
    }

    @Override
    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public Date getUpdated() {
        return updated;
    }

    @Override
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    @Override
    public String toString(){
        return "["+id+" "+fullname+" "+phone+", "+email+", "+address+"]";
    }
}
