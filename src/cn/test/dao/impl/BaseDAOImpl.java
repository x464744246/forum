package cn.test.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.test.dao.BaseDAO;
import cn.test.util.BaseDaoUtil;

@Repository("baseDAOImpl")
public class BaseDAOImpl<T> implements BaseDAO<T> {
	@SuppressWarnings("unchecked")
	protected Class<T> entityClass = BaseDaoUtil.getClassGenricType(getClass());

	@Autowired
	public SessionFactory sessionFactory;

	@Override
	public void add(T t) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(t);
		
	}

	@Override
	public T get(T t) {
		// TODO Auto-generated method stub
		String hql = "from "+ t.getClass().getName();
		List list = sessionFactory.getCurrentSession().createQuery(hql).list();
		Iterator<T> iterator = list.iterator();
		while(iterator.hasNext())
			t = iterator.next();
		return t;
	}

	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(t);
		
	}

	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(t);
	}

}
