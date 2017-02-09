package com.foray.bankjee.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.foray.bankjee.db.User;
import com.foray.bankjee.dao.UserDao;

public class JpaUserDao implements UserDao
{
	private EntityManagerFactory emf;
	
	public JpaUserDao(EntityManagerFactory emf)
	{
        this.emf = emf;
    }
	
	@Override
    public User add( User user )
	{
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        
        try
        {
            t.begin();
            
            em.persist( user );

            t.commit();
            
        }
        finally
        {
            if (t.isActive()) t.rollback();
            em.close();
        }
        
        return user;
    }
	
	@Override
    public Long findIfExist(String mail)
	{
        
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery( "SELECT COUNT(u) FROM User AS u WHERE u.mail = :mail" );
        query.setParameter("mail", mail);
        Long number = (Long) query.getSingleResult();
        
        em.close();
        
        return number;
    }
	
	@Override
	public User findConnectable(User user)
	{
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery( "SELECT u FROM User AS u WHERE u.mail = :mail AND u.password = :password AND u.activated = 1" );
        query.setParameter("mail", user.getMail());
        query.setParameter("password", user.getPassword());
        try
        {
        	User account = (User) query.getSingleResult();
        	em.close();
        	return account;
        }
		catch (Exception e)
        {
			em.close();
			return null;
		}
	}
	
	@Override
	public void update(User user)
	{
		EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        
        try
        {
            t.begin();
            em.merge( user );
            t.commit();
            
        } 
        finally
        {
            if (t.isActive()) t.rollback();
            em.close();
        }
	}
}
