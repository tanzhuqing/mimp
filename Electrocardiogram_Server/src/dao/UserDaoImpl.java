package dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

//import sunyang.domain.book.Book;
import domain.User;

public class UserDaoImpl  extends HibernateDaoSupport implements UserDao {
	//����û�
	public void save(User transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	//ɾ���û�
	public void delete(User persistentInstance) {
		try {
			User u = (User) this.getHibernateTemplate().load(User.class,
					persistentInstance.getId());
			getHibernateTemplate().delete(u);
		} catch (RuntimeException re) {
			throw re;
		}
		
	}

	//��id��ѯ�û�
	public User findById(Integer id) {
		try {
			User instance = (User) getHibernateTemplate().get(User.class, id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
  //����
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
//ģ����ѯ
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

	
//�����û���Ϣ
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
