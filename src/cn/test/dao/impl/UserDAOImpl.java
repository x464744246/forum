package cn.test.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.test.dao.UserDAO;
import cn.test.model.User;
import cn.test.util.BaseDaoUtil;

@Repository("userDAOImpl")
public class UserDAOImpl<T> implements UserDAO<T> {

	@SuppressWarnings("unchecked")
	protected Class<T> entityClass = BaseDaoUtil.getClassGenricType(getClass());

	@Autowired
	public SessionFactory sessionFactory;

	/**
	 * 根据Id查询实体
	 *
	 * @param id
	 */
	@SuppressWarnings("unchecked")
	public T getById(String id) {
		System.out.println("232323"+entityClass);
		T user = null;
		Session session = sessionFactory.getCurrentSession();
		List list = session.createQuery("from User where id = :ID").setParameter("ID", id).list();
		Iterator<T> iterator = list.iterator();
		while(iterator.hasNext())
			user = iterator.next();
		return user;

		// return (T)sessionFactory.getCurrentSession().get(entityClass, id);
	}
/*	@SuppressWarnings("unchecked")
	public List<T> getUsersById(String id) {
		System.out.println("232323"+entityClass);
		T user = null;
		Session session = sessionFactory.getCurrentSession();
		List list = session.createQuery("from User where id = :ID").setParameter("ID", id).list();
		Iterator<T> iterator = list.iterator();
		while(iterator.hasNext())
			user = iterator.next();
		return user;

		// return (T)sessionFactory.getCurrentSession().get(entityClass, id);
	}*/

	@Override
	public List<T> getUsersById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUser(T t) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(t);
		
	}
	@Override
	public void updateUser(T t) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(t);
	}


}
/*
 * package cn.test.dao;
 * 
 * import java.util.Iterator; import java.util.List;
 * 
 * import org.hibernate.Session;
 * 
 * import cn.test.model.User; import cn.test.util.HibernateUtil;
 * 
 * public class UserDAO { public User findUsers(User user) { Session session =
 * HibernateUtil.getSessionFactory().getCurrentSession();
 * session.beginTransaction();
 * System.out.println("11111111111111111111111111"+user.getId()); List list =
 * session.createQuery("from User where id = :ID") .setParameter("ID",
 * user.getId()).list(); Iterator iterator = list.iterator();
 * while(iterator.hasNext()){ User u = (User) iterator.next();
 * user.setLevel(u.getLevel()); user.setPassword(u.getPassword());
 * System.out.println("11111111111111111111111111"+user.getId());
 * System.out.println("11111111111111111111111111"+user.getLevel());
 * System.out.println("11111111111111111111111111"+user.getPassword()); }
 * 
 * session.getTransaction().commit(); return user; }
 * 
 * }
 */
