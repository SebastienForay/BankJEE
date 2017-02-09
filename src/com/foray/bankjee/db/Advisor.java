package com.foray.bankjee.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Advisor")
public class Advisor
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}