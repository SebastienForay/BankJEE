package com.foray.bankjee.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name="customer_fk")
    private Long id;
    private int shares;

    @OneToOne
    @JoinColumn(name="user_fk")
    private User user;

    @OneToOne
    @JoinColumn(name="checkingAccount_fk")
    private Account checkingAccount;
    
    @OneToOne
    @JoinColumn(name="savingAccount_fk")
    private Account savingAccount;
    
    // Getter
    public int getShares() {
    	return this.shares;
    }
    public User getUser() {
    	return this.user;
    }
    public Account getCheckingAccount() {
    	return this.checkingAccount;
    }
    public Account getsavingAccount() {
    	return this.savingAccount;
    }
    
    // Setter
    public void setShares(int shares) {
    	this.shares = shares;
    }
    public void setUser(User user) {
    	this.user = user;
    }
    public void setCheckingAccount(Account account) {
    	this.checkingAccount = account;
    }
    public void setSavingAccount(Account account) {
    	this.savingAccount = account;
    }
}
