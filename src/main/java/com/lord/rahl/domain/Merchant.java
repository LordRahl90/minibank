package com.lord.rahl.domain;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.List;

/**
 * Created by lordrahl on 12/10/2017.
 */
@Entity
@Table(name="merchants")
public class Merchant implements DomainObject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Integer version;
    private String name;

    private String email;
    private String phone;
    private String password="pass7word";

    @Enumerated(EnumType.STRING)
    Role role;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created=new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date updated=new Date();

    @OneToMany(mappedBy = "merchant")
    private List<Customer> customers;

    @OneToMany(mappedBy = "merchant")
    private List<TransactionManager> transactions;

    //empty constructor
    public Merchant(){

    }

    public Merchant(String name, String email, String phone){
        this.name=name;
        this.email=email;
        this.phone=phone;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<TransactionManager> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionManager> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString(){
        return "["+id+", "+phone+", "+email+", "+name+"]";
    }
}
