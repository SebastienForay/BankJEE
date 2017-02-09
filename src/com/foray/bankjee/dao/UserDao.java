package com.foray.bankjee.dao;

import com.foray.bankjee.db.User;

public interface UserDao {
	abstract User add(User user);
	abstract Long findIfExist(String mail);
	abstract User findConnectable(User user);
	abstract void update(User user);
}
