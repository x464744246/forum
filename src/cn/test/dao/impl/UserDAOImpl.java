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
public class UserDAOImpl<T> /* extends BaseDAOImpl<T>*/ implements UserDAO<T>{

	@SuppressWarnings("unchecked")
	protected Class<T> entityClass = BaseDaoUtil.getClassGenricType(getClass());

	@Autowired
	public SessionFactory sessionFactory;

	@Override
	public List<T> getUsersById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 根据Id查询实体
	 *
	 * @param id
	 */
	
	
	@SuppressWarnings("unchecked")
	public T get(T t) {
		System.out.println("232323"+entityClass);
		T user = null;
		Session session = sessionFactory.getCurrentSession();
		List list = session.createQuery("from User where id = :ID").setParameter("ID", ((User)t).getId()).list();
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

