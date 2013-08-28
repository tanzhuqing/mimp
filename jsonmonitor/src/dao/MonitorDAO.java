package dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Monitor entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see dao.Monitor
 * @author MyEclipse Persistence Tools
 */

public class MonitorDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(MonitorDAO.class);
	// property constants
	public static final String CONTENT = "content";
	public static final String LENGTH = "length";
	public static final String FRAME = "frame";

	public void save(Monitor transientInstance) {
		log.debug("saving Monitor instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Monitor persistentInstance) {
		log.debug("deleting Monitor instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Monitor findById(java.lang.Integer id) {
		log.debug("getting Monitor instance with id: " + id);
		try {
			Monitor instance = (Monitor) getSession().get("dao.Monitor", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Monitor instance) {
		log.debug("finding Monitor instance by example");
		try {
			List results = getSession().createCriteria("dao.Monitor")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Monitor instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Monitor as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findByLength(Object length) {
		return findByProperty(LENGTH, length);
	}

	public List findByFrame(Object frame) {
		return findByProperty(FRAME, frame);
	}

	public List findAll() {
		log.debug("finding all Monitor instances");
		try {
			String queryString = "from Monitor";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Monitor merge(Monitor detachedInstance) {
		log.debug("merging Monitor instance");
		try {
			Monitor result = (Monitor) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Monitor instance) {
		log.debug("attaching dirty Monitor instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Monitor instance) {
		log.debug("attaching clean Monitor instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}