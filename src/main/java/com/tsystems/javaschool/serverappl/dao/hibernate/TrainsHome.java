package com.tsystems.javaschool.serverappl.dao.hibernate;

// Generated 04.03.2013 3:19:57 by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.tsystems.javaschool.common.entities.Train;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Train.
 * 
 * @see .Train
 * @author Hibernate Tools
 */
public class TrainsHome {

	private static final Logger logger = Logger.getLogger(TrainsHome.class);

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

	public void persist(Train transientInstance) {
		logger.debug("persisting Train instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			logger.debug("persist successful");
		} catch (RuntimeException re) {
			logger.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Train instance) {
		logger.debug("attaching dirty Train instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			logger.debug("attach successful");
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Train instance) {
		logger.debug("attaching clean Train instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			logger.debug("attach successful");
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Train persistentInstance) {
		logger.debug("deleting Train instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	public Train merge(Train detachedInstance) {
		logger.debug("merging Train instance");
		try {
			Train result = (Train) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			logger.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("merge failed", re);
			throw re;
		}
	}

	public Train findById(String id) {
		logger.debug("getting Train instance with id: " + id);
		try {
			Train instance = (Train) sessionFactory.getCurrentSession().get(
					"Train", id);
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

	public List<Train> findByExample(Train instance) {
		logger.debug("finding Train instance by example");
		try {
			List<Train> results = (List<Train>) sessionFactory
					.getCurrentSession().createCriteria("Train")
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
