package com.foray.bankjee.dao;

import com.foray.bankjee.db.Advisor;

public interface AdvisorDao
{
	abstract Advisor add(Advisor advisor);
	abstract void update(Advisor advisor);
}
