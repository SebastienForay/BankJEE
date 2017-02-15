package com.foray.bankjee.db;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Account")
public class Account
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name="account_fk")
    private Long id;
    private String label;
    private Double balance;
    private Double interest;
    private Date creationDate;
    private int type;
    
    // Getter
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
    
    // Setter
    public void setLabel(String label) {
    	this.label = label;
    }
    public void setBalance(Double balance) {
    	this.balance = balance;
    }
    public void setInterest(Double interest) {
    	this.interest = interest;
    }
    public void setCreationDate(Date date) {
    	this.creationDate = date;
    }
    public void setType(int type) {
    	this.type = type;
    }
}