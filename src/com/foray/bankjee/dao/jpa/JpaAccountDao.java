package com.foray.bankjee.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.foray.bankjee.db.Account;
import com.foray.bankjee.db.User;
import com.foray.bankjee.dao.AccountDao;

public class JpaAccountDao implements AccountDao
{
	private EntityManagerFactory emf;
	
	public JpaAccountDao(EntityManagerFactory emf)
	{
        this.emf = emf;
    }
	
	@Override
    public Account add( Account account )
	{
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        
        try
        {
            t.begin();
            
            em.persist( account );

            t.commit();
            
        }
        finally
        {
            if (t.isActive()) t.rollback();
            em.close();
        }
        
        return account;
    }
	
	@Override
	public List<Account> findAll(User user)
	{
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT a FROM Account AS a WHERE a.id = ( SELECT c.checkingAccount FROM Customer AS c WHERE c.user = :user ) OR a.id = ( SELECT c.savingAccount FROM Customer AS c WHERE c.user = :user )");
        query.setParameter("user", user);
        
		List<Account> accounts = (List<Account>) query.getResultList();
    	em.close();
    	return accounts;
	}
	
	@Override
	public void update(Account account)
	{
		EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        
        try
        {
            t.begin();
            em.merge( account );
            t.commit();
            
        } 
        finally
        {
            if (t.isActive()) t.rollback();
            em.close();
        }
	}
}
