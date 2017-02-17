package com.foray.bankjee.dao;

import java.util.List;

import com.foray.bankjee.db.User;

public interface UserDao
{
	abstract User add(User user);
	abstract Long findIfExist(String mail);
	abstract User findConnectable(User user);
	abstract List<User> getAll();
	abstract void update(User user);
}
