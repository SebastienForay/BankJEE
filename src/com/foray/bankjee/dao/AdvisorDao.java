package com.foray.bankjee.dao;

import java.util.List;

import com.foray.bankjee.db.Advisor;
import com.foray.bankjee.db.User;

public interface AdvisorDao
{
	abstract Advisor add(Advisor advisor);
	abstract Advisor get(String id);
	abstract void update(Advisor advisor);
	abstract List<User> getAllCustomersForAdvisor(Advisor advisor);
}
