package com.foray.bankjee.db;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

    @JoinColumn(name="customer_fk")
    private Long customer;
    @JoinColumn(name="debitAccount_fk")
    private Long debitAccount;
    @JoinColumn(name="creditAccount_fk")
    private Long creditAccount;
    
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
}