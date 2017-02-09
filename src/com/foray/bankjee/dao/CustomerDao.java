package com.foray.bankjee.dao;

import com.foray.bankjee.db.Customer;

public interface CustomerDao
{
	abstract Customer add(Customer customer);
	abstract void update(Customer customer);
}
