package com.foray.bankjee.dao;

import com.foray.bankjee.db.Account;
import com.foray.bankjee.db.User;

public interface AccountDao
{
	abstract Account add(Account account);
	abstract Account getCheckingAccountForUser(User user);
	abstract Account getSavingAccountForUser(User user);
	abstract void update(Account account);
}
