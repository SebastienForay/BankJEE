package com.foray.bankjee.dao;

import com.foray.bankjee.dao.jpa.JpaUserDao;
import com.foray.bankjee.utils.PersistenceManager;


public class DaoFactory {
	public static UserDao getUserDao() {
	       return new JpaUserDao(PersistenceManager.getEntityManagerFactory());
	}
}
