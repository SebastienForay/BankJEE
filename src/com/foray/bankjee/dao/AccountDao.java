package com.foray.bankjee.dao;

import java.util.List;

import com.foray.bankjee.db.Account;
import com.foray.bankjee.db.User;

public interface AccountDao
{
	abstract Account add(Account account);
	abstract List<Account> findAll(User user);
	abstract Account getOne(User user, Long id);
	abstract void update(Account account);
}
