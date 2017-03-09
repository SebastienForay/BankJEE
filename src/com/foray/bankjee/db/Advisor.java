package com.foray.bankjee.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Advisor")
public class Advisor
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name="advisor_fk")
    private Long id;

    @OneToOne
    @JoinColumn(name="user_fk")
    private User user;
    
    // Getter
    public Long getId() {
    	return this.id;
    }
    public User getUser() {
    	return this.user;
    }
    
    // Setter
    public void setId(Long id) {
    	this.id = id;
    }
    public void setUser(User user) {
    	this.user = user;
    }
}