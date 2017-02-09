package com.foray.bankjee.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private int type;

    // Getter
    public String getFirstname() {
    	return this.firstname;
    }
    public String getLastname() {
    	return this.lastname;
    }
    public String getEmail() {
    	return this.email;
    }
    public String getPassword() {
    	return this.password;
    }
    public int getType() {
    	return this.type;
    }

    // Setter
    public void setFirstname(String firstname) {
    	this.firstname = firstname;
    }
    public void setLastname(String lastname) {
    	this.lastname = lastname;
    }
    public void setEmail(String email) {
    	this.email = email;
    }
    public void setPassword(String password) {
    	this.password = password;
    }
    public void setType(int type) {
    	this.type = type;
    }
}