package dao;

import java.util.List;

import domain.User;



public interface UserDao {
	public void save(User transientInstance);

	public void delete(User persistentInstance);

	public User findById(java.lang.Integer id);

	public List<User> findByProperty(String propertyName, Object value);

	public List<User> findByVagueProperty(String propertyName, Object value);

	public User merge(User detachedInstance);
}
