package com.tsystems.javaschool.serverappl.dao.hibernate;

// Generated 04.03.2013 3:19:57 by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.hibernate.LockOptions;
import org.hibernate.SessionFactory;

import com.tsystems.javaschool.common.entities.User;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class User.
 * 
 * @see .User
 * @author Hibernate Tools
 */
public class UsersHome {

	private static final Logger logger = Logger.getLogger(UsersHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			logger.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(User transientInstance) {
		logger.debug("persisting User instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			logger.debug("persist successful");
		} catch (RuntimeException re) {
			logger.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(User instance) {
		logger.debug("attaching dirty User instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			logger.debug("attach successful");
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(User instance) {
		logger.debug("attaching clean User instance");
		try {
			sessionFactory.getCurrentSession()
					.buildLockRequest(LockOptions.NONE).lock(instance);
			logger.debug("attach successful");
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}

	public void delete(User persistentInstance) {
		logger.debug("deleting User instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	public User merge(User detachedInstance) {
		logger.debug("merging User instance");
		try {
			User result = (User) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			logger.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("merge failed", re);
			throw re;
		}
	}

	public User findById(Long id) {
		logger.debug("getting User instance with id: " + id);
		try {
			User instance = (User) sessionFactory.getCurrentSession().get(
					"User", id);
			if (instance == null) {
				logger.debug("get successful, no instance found");
			} else {
				logger.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			logger.error("get failed", re);
			throw re;
		}
	}

	public List<User> findByExample(User instance) {
		logger.debug("finding User instance by example");
		try {
			List<User> results = (List<User>) sessionFactory
					.getCurrentSession().createCriteria("User")
					.add(create(instance)).list();
			logger.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			logger.error("find by example failed", re);
			throw re;
		}
	}
}
