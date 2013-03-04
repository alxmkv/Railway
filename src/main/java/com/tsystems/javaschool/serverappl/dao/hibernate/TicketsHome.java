package com.tsystems.javaschool.serverappl.dao.hibernate;

// Generated 04.03.2013 3:19:57 by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.tsystems.javaschool.common.entities.Ticket;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Ticket.
 * 
 * @see .Ticket
 * @author Hibernate Tools
 */
public class TicketsHome {

	private static final Logger logger = Logger.getLogger(TicketsHome.class);

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

	public void persist(Ticket transientInstance) {
		logger.debug("persisting Ticket instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			logger.debug("persist successful");
		} catch (RuntimeException re) {
			logger.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Ticket instance) {
		logger.debug("attaching dirty Ticket instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			logger.debug("attach successful");
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Ticket instance) {
		logger.debug("attaching clean Ticket instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			logger.debug("attach successful");
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Ticket persistentInstance) {
		logger.debug("deleting Ticket instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	public Ticket merge(Ticket detachedInstance) {
		logger.debug("merging Ticket instance");
		try {
			Ticket result = (Ticket) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			logger.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("merge failed", re);
			throw re;
		}
	}

	public Ticket findById(String id) {
		logger.debug("getting Ticket instance with id: " + id);
		try {
			Ticket instance = (Ticket) sessionFactory.getCurrentSession().get(
					"Ticket", id);
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

	public List<Ticket> findByExample(Ticket instance) {
		logger.debug("finding Ticket instance by example");
		try {
			List<Ticket> results = (List<Ticket>) sessionFactory
					.getCurrentSession().createCriteria("Ticket")
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
