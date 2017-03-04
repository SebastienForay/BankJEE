package com.foray.bankjee.dao;

import java.util.List;

import com.foray.bankjee.db.Customer;
import com.foray.bankjee.db.Transaction;

public interface TransactionDao
{
	abstract Transaction add(Transaction transaction);
	abstract List<Transaction> findAll(Customer customer);
	abstract Transaction getOne(Customer customer, Long id);
	abstract void update(Transaction transaction);
}