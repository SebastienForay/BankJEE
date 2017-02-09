package com.foray.bankjee.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.foray.bankjee.db.Advisor;
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
}
