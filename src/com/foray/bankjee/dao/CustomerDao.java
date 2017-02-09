package com.foray.bankjee.dao;

import com.foray.bankjee.db.Customer;

public interface CustomerDao
{
	abstract Customer add(Customer user);
	abstract Long findIfExist(String mail);
	abstract Customer findConnectable(Customer user);
	abstract void update(Customer user);
}
