package com.foray.bankjee.dao.jpa;

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
	public Account getCheckingAccountForUser(User user)
	{
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery( "SELECT a FROM Account AS a WHERE a.id = (" +
										"SELECT checkingAccount_fk FROM Customer WHERE User = (" +
												"SELECT id FROM User WHERE email = :email" +
											")" +
									 	")"
									);
        query.setParameter("email", user.getEmail());
        
        try {
        	Account account = (Account) query.getSingleResult();
        	em.close();
        	return account;
        }
		catch (Exception e) {
			em.close();
			return null;
		}
	}
	
	@Override
	public Account getSavingAccountForUser(User user)
	{
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery( "SELECT a FROM Account AS a WHERE a.id = (" +
										"SELECT savingAccount_fk FROM Customer WHERE User = (" +
												"SELECT id FROM User WHERE email = :email" +
											")" +
									 	")"
									);
        query.setParameter("email", user.getEmail());
        
        try {
        	Account account = (Account) query.getSingleResult();
        	em.close();
        	return account;
        }
		catch (Exception e) {
			em.close();
			return null;
		}
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
