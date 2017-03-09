package com.foray.bankjee.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.foray.bankjee.db.Advisor;
import com.foray.bankjee.db.User;
import com.foray.bankjee.dao.AdvisorDao;

public class JpaAdvisorDao implements AdvisorDao
{
	private EntityManagerFactory emf;
	
	public JpaAdvisorDao(EntityManagerFactory emf)
	{
        this.emf = emf;
    }
	
	@Override
    public Advisor add( Advisor advisor )
	{
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        
        try
        {
            t.begin();
            
            em.persist( advisor );

            t.commit();
            
        }
        finally
        {
            if (t.isActive()) t.rollback();
            em.close();
        }
        
        return advisor;
    }
	
	@Override
    public Advisor get(String id)
	{
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT a FROM Advisor AS a WHERE a.user = (SELECT u FROM User AS u WHERE u.id = :id)");
		query.setParameter("id", Long.parseLong(id));
        try
        {
    		Advisor advisor = (Advisor) query.getSingleResult();
        	em.close();
    		return advisor;
        }
		catch (Exception e)
        {
			em.close();
			return null;
		}
    }
	
	@Override
	public void update(Advisor advisor)
	{
		EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        
        try
        {
            t.begin();
            em.merge( advisor );
            t.commit();
            
        } 
        finally
        {
            if (t.isActive()) t.rollback();
            em.close();
        }
	}
	
	@Override
	public List<User> getAllCustomersForAdvisor(Advisor advisor)
	{
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT u FROM User AS u WHERE u.id = (SELECT c.user FROM Customer AS c WHERE c.advisor = :advisor)");
		query.setParameter("advisor", advisor);
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
}
