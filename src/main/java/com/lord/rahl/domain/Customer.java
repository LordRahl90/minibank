package com.lord.rahl.domain;

import javax.persistence.*;
import java.time.Instant;

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

    @ManyToOne(cascade = CascadeType.ALL)
    private Merchant merchant;

    private Instant created=Instant.now();
    private Instant updated=Instant.now();

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

    @Override
    public void setCreated(Instant created) {

    }

    @Override
    public Instant getCreated() {
        return null;
    }

    @Override
    public void setUpdated(Instant update) {

    }

    @Override
    public Instant getUpdated() {
        return null;
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

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }


}
