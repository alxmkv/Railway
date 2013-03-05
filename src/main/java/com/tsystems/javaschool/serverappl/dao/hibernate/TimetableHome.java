package com.tsystems.javaschool.serverappl.dao.hibernate;

// Generated 04.03.2013 3:19:57 by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.hibernate.LockOptions;
import org.hibernate.SessionFactory;

import com.tsystems.javaschool.common.entities.Timetable;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Timetable.
 * 
 * @see .Timetable
 * @author Hibernate Tools
 */
public class TimetableHome {

	private static final Logger logger = Logger.getLogger(TimetableHome.class);

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

	public void persist(Timetable transientInstance) {
		logger.debug("persisting Timetable instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			logger.debug("persist successful");
		} catch (RuntimeException re) {
			logger.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Timetable instance) {
		logger.debug("attaching dirty Timetable instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			logger.debug("attach successful");
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Timetable instance) {
		logger.debug("attaching clean Timetable instance");
		try {
			sessionFactory.getCurrentSession()
					.buildLockRequest(LockOptions.NONE).lock(instance);
			logger.debug("attach successful");
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Timetable persistentInstance) {
		logger.debug("deleting Timetable instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	public Timetable merge(Timetable detachedInstance) {
		logger.debug("merging Timetable instance");
		try {
			Timetable result = (Timetable) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			logger.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("merge failed", re);
			throw re;
		}
	}

	public Timetable findById(Long id) {
		logger.debug("getting Timetable instance with id: " + id);
		try {
			Timetable instance = (Timetable) sessionFactory.getCurrentSession()
					.get("Timetable", id);
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

	public List<Timetable> findByExample(Timetable instance) {
		logger.debug("finding Timetable instance by example");
		try {
			List<Timetable> results = (List<Timetable>) sessionFactory
					.getCurrentSession().createCriteria("Timetable")
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
