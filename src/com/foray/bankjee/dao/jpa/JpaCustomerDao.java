package com.foray.bankjee.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.foray.bankjee.db.Customer;
import com.foray.bankjee.db.User;
import com.foray.bankjee.dao.CustomerDao;

public class JpaCustomerDao implements CustomerDao
{
	private EntityManagerFactory emf;
	
	public JpaCustomerDao(EntityManagerFactory emf)
	{
        this.emf = emf;
    }
	
	@Override
    public Customer add( Customer customer )
	{
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        
        try
        {
            t.begin();
            
            em.persist( customer );

            t.commit();
            
        }
        finally
        {
            if (t.isActive()) t.rollback();
            em.close();
        }
        
        return customer;
    }
	
	@Override
	public void update(Customer customer)
	{
		EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        
        try
        {
            t.begin();
            em.merge( customer );
            t.commit();
            
        } 
        catch(Exception e)
        {
            em.close();
        }
	}
	
	@Override
	public Customer getOne(User user)
	{
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery( "SELECT c FROM Customer AS c WHERE c.user = :user" );
        query.setParameter("user", user);
        try
        {
        	Customer customer = (Customer) query.getSingleResult();
        	em.close();
        	return customer;
        }
		catch (Exception e)
        {
			em.close();
			return null;
		}
	}
}
