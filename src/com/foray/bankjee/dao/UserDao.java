package com.foray.bankjee.dao;

import java.util.List;

import com.foray.bankjee.db.Advisor;
import com.foray.bankjee.db.User;

public interface UserDao
{
	abstract User add(User user);
	abstract Long findIfExist(String mail);
	abstract User findConnectable(User user);
	abstract List<User> getAll();
	abstract List<User> getAllByType(int type);
	abstract void update(User user);
	abstract User getOne(String id, String email);
	abstract User getOneFromAdvisorId(String id);
}
