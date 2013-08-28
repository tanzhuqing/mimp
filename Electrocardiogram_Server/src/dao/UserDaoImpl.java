package dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

//import sunyang.domain.book.Book;
import domain.User;

public class UserDaoImpl  extends HibernateDaoSupport implements UserDao {
	//添加用户
	public void save(User transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	//删除用户
	public void delete(User persistentInstance) {
		try {
			User u = (User) this.getHibernateTemplate().load(User.class,
					persistentInstance.getId());
			getHibernateTemplate().delete(u);
		} catch (RuntimeException re) {
			throw re;
		}
		
	}

	//按id查询用户
	public User findById(Integer id) {
		try {
			User instance = (User) getHibernateTemplate().get(User.class, id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
  //查找
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from User as model where model."
					+ propertyName + "= ?";
			Query queryObject = getHibernateTemplate().getSessionFactory()
					.openSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}
//模糊查询
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findByVagueProperty(String propertyName, Object value) {
		try {
			String queryString = "from User as model where model."
					+ propertyName + " like '%" + value + "%' and model."
					+ propertyName + " !='" + value + "'";
			Query queryObject = getHibernateTemplate().getSessionFactory()
					.openSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	
//更新用户信息
	@Override
	public User merge(User detachedInstance) {
		try {
			User result = (User) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}

}
