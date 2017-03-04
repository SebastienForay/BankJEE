package com.foray.bankjee.db;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Transaction")
public class Transaction
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double amount;
    private Date date;
    private String comment;

    @OneToOne
    @JoinColumn(name="customer_fk")
    private Customer customer;

    @OneToOne
    @JoinColumn(name="debitAccount_fk")
    private Account debitAccount;

    @OneToOne
    @JoinColumn(name="creditAccount_fk")
    private Account creditAccount;
    
    // Getter
    public Double getAmount() {
    	return this.amount;
    }
    public Date getDate() {
    	return this.date;
    }
    public String getComment() {
    	return this.comment;
    }
    public Customer getCustomer() {
    	return this.customer;
    }
    public Account getDebitAccount() {
    	return this.debitAccount;
    }
    public Account getCreditAccout() {
    	return this.creditAccount;
    }
    
    // Setter
    public void setAmount(double amount) {
    	this.amount = amount;
    }
    public void setDate(Date date) {
    	this.date = date;
    }
    public void setComment(String comment) {
    	this.comment = comment;
    }
    public void setCustomer(Customer customer) {
    	this.customer = customer;
    }
    public void setDebitAccount(Account account) {
    	this.debitAccount = account;
    }
    public void setCreditAccount(Account account) {
    	this.creditAccount = account;
    }
}