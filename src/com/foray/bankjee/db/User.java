package com.foray.bankjee.db;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.foray.bankjee.utils.Encrypt;

@Entity
@Table(name = "user")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String firstname;
    private String lastname;
    private String mail;
    private String password;

    @OneToMany(mappedBy="user")
    private List<Account> accounts;
    
    @ManyToOne
    @JoinColumn(name="advisor_fk")
    private Advisor advisor;

    // getter
    public Long getId() {
        return this.id;
    }

    public String getFirstname() {
        return this.firstname;
    }
    
    public String getLastname() {
        return this.lastname;
    }
    
    public String getMail() {
    	return this.mail;
    }
    
    public String getPassword() {
    	return this.password;
    }    
    
    //setter
    public void setId( Long id ) {
        this.id = id;
    }

    public void setFirstname( String fname ) {
        this.firstname = fname;
    }

    public void setLastname( String lname ) {
        this.lastname = lname;
    }
    
    public void setMail( String mail ) {
    	this.mail = mail;
    }
    
    public void setPassword( String password ) {
    	this.password = Encrypt.encryptPassword(password);
    }   
    
    public List<Account> getAccount() {
        return this.accounts;
    }
    
    public void setAccount( Account account ) {
    	this.accounts.add(account);
    }
}