package com.foray.bankjee.dao;

import com.foray.bankjee.dao.jpa.JpaCustomerDao;
import com.foray.bankjee.utils.PersistenceManager;


public class DaoFactory {
	public static CustomerDao getCustomerDao() {
	       return new JpaCustomerDao(PersistenceManager.getEntityManagerFactory());
	}
}
