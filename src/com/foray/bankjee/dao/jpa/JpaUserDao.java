package com.foray.bankjee.dao.jpa;

import java.util.List;

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
    public Long findIfExist(String email)
	{
        
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery( "SELECT COUNT(u) FROM User AS u WHERE u.email = :email" );
        query.setParameter("email", email);
        Long number = (Long) query.getSingleResult();
        
        em.close();
        
        return number;
    }
	
	@Override
	public User findConnectable(User user)
	{
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery( "SELECT u FROM User AS u WHERE u.email = :email AND u.password = :password" );
        query.setParameter("email", user.getEmail());
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
	public List<User> getAll()
	{
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery( "SELECT u FROM User AS u ORDER BY u.type DESC" );
        try
        {
    		List<User> users = (List<User>) query.getResultList();
        	em.close();
    		return users;
        }
		catch (Exception e)
        {
			em.close();
			return null;
		}
	}
	
	@Override
	public List<User> getAllByType(int type)
	{
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery( "SELECT u FROM User AS u WHERE u.type = :type" );
        query.setParameter("type", type);
        try
        {
    		List<User> users = (List<User>) query.getResultList();
        	em.close();
    		return users;
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
		catch (Exception e)
        {
			em.close();
		}
	}

	@Override
	public User getOne(String id, String email)
	{
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery( "SELECT u FROM User AS u WHERE u.id = :id AND u.email = :email" );
        query.setParameter("id", Long.parseLong(id));
        query.setParameter("email", email);
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
	public User getOneFromAdvisorId(String id)
	{
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery( "SELECT u FROM User AS u WHERE u.id = :id" );
        query.setParameter("id", Long.parseLong(id));
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
}
