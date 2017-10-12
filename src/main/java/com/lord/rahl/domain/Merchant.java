package com.lord.rahl.domain;

import javax.persistence.*;
import java.time.Instant;

/**
 * Created by lordrahl on 12/10/2017.
 */
@Entity
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

    private Instant created=Instant.now();
    private Instant updated=Instant.now();

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

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getUpdated() {
        return updated;
    }

    public void setUpdated(Instant updated) {
        this.updated = updated;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
