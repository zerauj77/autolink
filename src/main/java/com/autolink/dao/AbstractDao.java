package com.autolink.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.autolink.interfaces.AbstractIF;

public class AbstractDao implements AbstractIF {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean save(Object obj) {
		try {
        	sessionFactory.getCurrentSession().beginTransaction();
            sessionFactory.getCurrentSession().save(obj);
            sessionFactory.getCurrentSession().getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            sessionFactory.getCurrentSession().getTransaction().rollback();
            throw e;
        }
	}

	@Override
	@SuppressWarnings("rawtypes")
	public List findAll(Class clazz) {
		List objects = null;
        
        try {
        	sessionFactory.getCurrentSession().beginTransaction();
            Query query = sessionFactory.getCurrentSession().createQuery("from " + clazz.getName());
            objects = query.list();
            sessionFactory.getCurrentSession().getTransaction().commit();
        } catch (HibernateException e) {
            sessionFactory.getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
            throw e;
        }
        return objects;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public List findByWhereStatement(Class clazz, String whereStatement) {
		List objects = null;
        
        try {
        	sessionFactory.getCurrentSession().beginTransaction();
            Query query = sessionFactory.getCurrentSession().createQuery("from " + clazz.getName() + " where " + whereStatement);
            objects = query.list();
            sessionFactory.getCurrentSession().getTransaction().commit();
            
        } catch (RuntimeException re) {
            sessionFactory.getCurrentSession().getTransaction().rollback();
            //LOG.error("find by where statement failed", re);
            throw re;
        }
        return objects;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public List findValuesByWhereStatement(Class clazz, String values,
			String whereStatement) {
		List objects = null;
        
        try {
        	sessionFactory.getCurrentSession().beginTransaction();
            Query query = sessionFactory.getCurrentSession().createQuery("select " + values + " from " + clazz.getName() + " where " + whereStatement);
            objects = query.list();
            sessionFactory.getCurrentSession().getTransaction().commit();
        } catch (RuntimeException re) {
            sessionFactory.getCurrentSession().getTransaction().rollback();
            //LOG.error("find by where statement failed", re);
            throw re;
        }
        return objects;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public List executeHQLStatement(String HQLstatement) {
		List objects = null;
        
        try {
        	sessionFactory.getCurrentSession().beginTransaction();
            Query query = sessionFactory.getCurrentSession().createQuery(HQLstatement);
            objects = query.list();
            sessionFactory.getCurrentSession().getTransaction().commit();
        } catch (RuntimeException re) {
            sessionFactory.getCurrentSession().getTransaction().rollback();
            //LOG.error("executeHQLStatement failed", re);
            throw re;
        }
        return objects;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public List executeNamedQuery(String name) {
		try {
        	sessionFactory.getCurrentSession().beginTransaction();
            Query query = sessionFactory
                    .getCurrentSession()
                    .getNamedQuery(name);
            List result = query.list();
            sessionFactory.getCurrentSession().getTransaction().commit();
            return result;
        } catch (RuntimeException rex) {
            sessionFactory.getCurrentSession().getTransaction().rollback();
            //LOG.error("executeNamedQuery failed");
            throw rex;
            //return new ArrayList();
        }
	}

	@Override
	@SuppressWarnings("rawtypes")
	public List executeNamedQuery(String name, Object[] parameters) {
		List objects;
        objects = null;
        int index = 0;

        try {
        	sessionFactory.getCurrentSession().beginTransaction();
            Query query = sessionFactory
                    .getCurrentSession()
                    .getNamedQuery(name);
            for (Object param : parameters) {
                query.setParameter(index, param);
                index++;
            }
            objects = query.list();
            sessionFactory.getCurrentSession().getTransaction().commit();
        } catch (RuntimeException rex) {
            sessionFactory.getCurrentSession().getTransaction().rollback();
            //LOG.error("executeNamedQuery failed");
            throw rex;
        }
        return objects;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public List executeNamedQuery(String name, String[] paramNames,
			Object[] parameters) throws HibernateException{
		List objects;
        objects = null;
        int index = 0;
        
        try {
        	sessionFactory.getCurrentSession().beginTransaction();
            Query query = sessionFactory
                    .getCurrentSession()
                    .getNamedQuery(name);
            for (Object param : parameters) {
                query.setParameter(paramNames[index], param);
                index++;
            }
            objects = query.list();
            sessionFactory.getCurrentSession().getTransaction().commit();
            
        } catch (HibernateException rex) {
            sessionFactory.getCurrentSession().getTransaction().rollback();
            //LOG.error("executeNamedQuery failed");
            throw rex;
        }
        return objects;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Object findUniqueResult(Class clazz, String whereStatement) {
		Object object = null;
        try {
            sessionFactory.getCurrentSession().beginTransaction();
            Query query = sessionFactory.getCurrentSession().createQuery("from " + clazz.getName() + " where " + whereStatement);
            object = query.uniqueResult();
            sessionFactory.getCurrentSession().getTransaction().commit();
        } catch (RuntimeException re) {
            sessionFactory.getCurrentSession().getTransaction().rollback();
            //LOG.error("find UniqueResult failed", re);
            throw re;
        }
        return object;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Object findFirstRow(Class clazz, String whereStatement) {
		Object object = null;
        try {
            sessionFactory.getCurrentSession().beginTransaction();
            Query query = sessionFactory.getCurrentSession().createQuery("from " + clazz.getName() + " where " + whereStatement);
            List results = query.list();
            if (results.size() > 0) {
                object = results.get(0);
            }
            sessionFactory.getCurrentSession().getTransaction().commit();
        } catch (RuntimeException re) {
            sessionFactory.getCurrentSession().getTransaction().rollback();
            //LOG.error("find UniqueResult failed", re);
            throw re;
        }
        return object;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public void refreshObjects(List objects) {
		for (Object object : objects) {
            sessionFactory.getCurrentSession().refresh(object);
        }

	}

	@Override
	public void refreshObject(Object object) {
		sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().refresh(object);
        sessionFactory.getCurrentSession().getTransaction().commit();
	}

//	public SessionFactory getSessionFactory() {
//		return sessionFactory;
//	}
//
//	public void setSessionFactory(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}

	@Override
	public void delete(Object obj) throws HibernateException{
		try {
        	sessionFactory.getCurrentSession().beginTransaction();
            sessionFactory.getCurrentSession().delete(obj);
            sessionFactory.getCurrentSession().getTransaction().commit();
            
        } catch (HibernateException e) {
            sessionFactory.getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
            throw e;
        }
	}

	@Override
	public boolean update(Object obj) {
		try {
        	sessionFactory.getCurrentSession().beginTransaction();
            sessionFactory.getCurrentSession().update(obj);
            sessionFactory.getCurrentSession().getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            sessionFactory.getCurrentSession().getTransaction().rollback();
            throw e;
        }
	}
	
	
	@Override
	@SuppressWarnings("rawtypes")
	public List findAllOrderBy(Class clazz, int start, int limit, String orderBy) {
		List objects = null;        
        try {
        	sessionFactory.getCurrentSession().beginTransaction();
            Query query = sessionFactory.getCurrentSession().createQuery("from " + clazz.getName() + " order by " + orderBy);
            query.setFirstResult(start);
            query.setMaxResults(limit);
            objects = query.list();
            sessionFactory.getCurrentSession().getTransaction().commit();
        } catch (HibernateException e) {
            sessionFactory.getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
            throw e;
        }
        return objects;
	}
	
}



