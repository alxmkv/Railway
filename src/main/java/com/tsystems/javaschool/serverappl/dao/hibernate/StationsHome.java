package com.tsystems.javaschool.serverappl.dao.hibernate;

// Generated 04.03.2013 3:19:57 by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.tsystems.javaschool.common.entities.Station;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Station.
 * 
 * @see .Station
 * @author Hibernate Tools
 */
public class StationsHome {

	private static final Logger logger = Logger.getLogger(StationsHome.class);

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

	public void persist(Station transientInstance) {
		logger.debug("persisting Station instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			logger.debug("persist successful");
		} catch (RuntimeException re) {
			logger.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Station instance) {
		logger.debug("attaching dirty Station instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			logger.debug("attach successful");
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Station instance) {
		logger.debug("attaching clean Station instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			logger.debug("attach successful");
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Station persistentInstance) {
		logger.debug("deleting Station instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	public Station merge(Station detachedInstance) {
		logger.debug("merging Station instance");
		try {
			Station result = (Station) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			logger.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("merge failed", re);
			throw re;
		}
	}

	public Station findById(String id) {
		logger.debug("getting Station instance with id: " + id);
		try {
			Station instance = (Station) sessionFactory.getCurrentSession()
					.get("Station", id);
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

	public List<Station> findByExample(Station instance) {
		logger.debug("finding Station instance by example");
		try {
			List<Station> results = (List<Station>) sessionFactory
					.getCurrentSession().createCriteria("Station")
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
