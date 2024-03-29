package com.foray.bankjee.dao;

import com.foray.bankjee.db.Customer;
import com.foray.bankjee.db.User;

public interface CustomerDao
{
	abstract Customer add(Customer customer);
	abstract void update(Customer customer);
	abstract Customer getOne(User user);
}
