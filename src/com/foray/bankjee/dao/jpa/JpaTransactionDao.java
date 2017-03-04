package com.foray.bankjee.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.foray.bankjee.dao.TransactionDao;
import com.foray.bankjee.db.Customer;
import com.foray.bankjee.db.Transaction;

public class JpaTransactionDao implements TransactionDao
{
	private EntityManagerFactory emf;
	
	public JpaTransactionDao(EntityManagerFactory emf)
	{
        this.emf = emf;
    }
	@Override
	public Transaction add(Transaction transaction)
	{
		EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        
        try
        {
            t.begin();
            
            em.persist( transaction );

            t.commit();
            
        }
        finally
        {
            if (t.isActive()) t.rollback();
            em.close();
        }
        
        return transaction;
	}

	@Override
	public List<Transaction> findAll(Customer customer)
	{
		return null;
	}

	@Override
	public Transaction getOne(Customer customer, Long id)
	{
		return null;
	}

	@Override
	public void update(Transaction transaction)
	{
		
	}
	
}
