package com.foray.bankjee.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.foray.bankjee.dao.TransactionDao;
import com.foray.bankjee.db.Account;
import com.foray.bankjee.db.Customer;
import com.foray.bankjee.db.Transaction;
import com.foray.bankjee.db.User;

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
	public List<Transaction> findAll(Customer customer, Account account)
	{
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery( "SELECT t FROM Transaction AS t WHERE t.customer = :customer AND t.debitAccount = :account OR t.creditAccount = :account ORDER BY date DESC" );
        query.setParameter("customer", customer);
        query.setParameter("account", account);
        
        try
        {
    		List<Transaction> transactions = (List<Transaction>) query.getResultList();
        	em.close();
    		return transactions;
        }
		catch (Exception e)
        {
			em.close();
			return null;
		}
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
