package com.prac.springboot.springbootdemo.customer.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.Date;
//https://www.mkyong.com/spring-boot/spring-boot-spring-data-jpa-oracle-example/
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String email;

    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer(Long id, String name, String email, Date date) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.date = date;
    }

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.date = new Date();
    }

    public Customer(){

    }
}
