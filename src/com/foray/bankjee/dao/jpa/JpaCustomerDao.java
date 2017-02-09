package com.foray.bankjee.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.foray.bankjee.db.Customer;
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
    public Long findIfExist(String mail)
	{
        
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery( "SELECT COUNT(c) FROM Customer AS c WHERE c.mail = :mail" );
        query.setParameter("mail", mail);
        Long number = (Long) query.getSingleResult();
        
        em.close();
        
        return number;
    }
	
	@Override
	public Customer findConnectable(Customer user)
	{
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery( "SELECT c FROM Customer AS c WHERE c.mail = :mail AND c.password = :password" );
        query.setParameter("mail", user.getMail());
        query.setParameter("password", user.getPassword());
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
        finally
        {
            if (t.isActive()) t.rollback();
            em.close();
        }
	}
}
