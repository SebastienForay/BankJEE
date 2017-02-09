package com.foray.bankjee.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String label;
    private Double balance;
    private Double interest;
    
    @ManyToOne
    @JoinColumn(name="user_fk")
    private User user;

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
    
    public User getUSer() {
        return this.user;
    }
    
    public void setUser( User user ) {
        this.user = user;
    }
}