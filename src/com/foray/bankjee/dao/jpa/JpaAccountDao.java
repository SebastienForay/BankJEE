package com.foray.bankjee.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.foray.bankjee.db.Account;
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
