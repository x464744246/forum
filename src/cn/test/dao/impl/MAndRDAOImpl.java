package cn.test.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.test.dao.MAndRDAO;
import cn.test.dao.MessageDAO;
import cn.test.util.BaseDaoUtil;

@Repository("mAndRDAOImpl")
public class MAndRDAOImpl<T> implements MAndRDAO<T>{
	@SuppressWarnings("unchecked")
	protected Class<T> entityClass = BaseDaoUtil.getClassGenricType(getClass());

	@Autowired
	public SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	public List<T> getRelysByID(String id, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from MAndR where id = :ID order by createdate desc").setParameter("ID", id).setFirstResult((currentPage - 1) * pageSize)// ִ�з�ҳ
				.setMaxResults(pageSize).list();
	}

	@Override
	public int getPageCount(String id, int pageSize) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from MAndR where id = :ID").setParameter("ID", id).list().size()/pageSize;
		
	}


}
