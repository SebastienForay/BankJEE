package com.foray.bankjee.dao;

import com.foray.bankjee.dao.jpa.*;
import com.foray.bankjee.utils.PersistenceManager;


public class DaoFactory
{
	public static UserDao getUserDao()
	{
	       return new JpaUserDao(PersistenceManager.getEntityManagerFactory());
	}
	
	public static CustomerDao getCustomerDao()
	{
	       return new JpaCustomerDao(PersistenceManager.getEntityManagerFactory());
	}
	
	public static AccountDao getAccountDao()
	{
	       return new JpaAccountDao(PersistenceManager.getEntityManagerFactory());
	}
	
	public static AdvisorDao getAdvisorDao()
	{
	       return new JpaAdvisorDao(PersistenceManager.getEntityManagerFactory());
	}
	
	public static TransactionDao getTransactionDao()
	{
		return new JpaTransactionDao(PersistenceManager.getEntityManagerFactory());
	}
}
