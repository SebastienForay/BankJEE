package com.foray.bankjee.dao;

import com.foray.bankjee.db.Account;

public interface AccountDao
{
	abstract Account add(Account account);
	abstract void update(Account account);
}
