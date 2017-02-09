package com.foray.bankjee.db;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Account")
public class Account
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String label;
    private Double balance;
    private Double interest;
    private Date creationDate;
    
    @ManyToOne
    @JoinColumn(name="customer_fk")
    private Customer customer;

    // getter
    public Long getId() {
        return this.id;
    }
    
    public String getLabel() {
        return this.label;
    }
    
    public Double getBalance() {
        return this.balance;
    }
    
    public Double getInterest() {
        return this.interest;
    }
    
    public Date getCreationDate() {
        return this.creationDate;
    }
    
    public Customer getCustomer() {
        return this.customer;
    }
    
    
    //setter
    public void setId( Long id ) {
        this.id = id;
    }
    
    public void setLabel(String lbl) {
        this.label = lbl;
    }
    
    public void setBalance(Double bal) {
        this.balance = bal;
    }
    
    public void setInterest(Double interests) {
        this.interest = interests;
    }
    
    public void setCreationDate(Date date) {
        this.creationDate = date;
    }
    
    public void setUser( Customer custmr ) {
        this.customer = custmr;
    }
}