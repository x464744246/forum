package cn.test.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.test.dao.ReplyDAO;
import cn.test.util.BaseDaoUtil;
@Repository("replyDAOImpl")
public class ReplyDAOImpl<T> implements ReplyDAO<T>{
	@SuppressWarnings("unchecked")
	protected Class<T> entityClass = BaseDaoUtil.getClassGenricType(getClass());

	@Autowired
	public SessionFactory sessionFactory;

	
	public List<T> getReplys(String messageid) {
		// TODO Auto-generated method stub

		T reply = null;
		Session session = sessionFactory.getCurrentSession();
		List<T> list = session.createQuery("from Reply where messageid = :ID").setParameter("ID", messageid).list();
	
		return list;

		
	}


	@Override
	@SuppressWarnings("unchecked")
	public List<T> getPageByReplys(String messageid,int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Reply where messageid = :ID order by createdate desc").setParameter("ID", messageid).setFirstResult((currentPage - 1) * pageSize)// ִ�з�ҳ
				.setMaxResults(pageSize).list();}


	@Override
	public int getPageCount(String messageid,int pageSize) {
		return sessionFactory.getCurrentSession().createQuery("from Reply where messageid = :ID").setParameter("ID", messageid).list().size()/pageSize;
		}


	@Override
	public void add(T t) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(t);
	}


	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().delete(t);
	}


	@Override
	public void deleteReplys(String messageid) {
		// TODO Auto-generated method stub
		
	
		sessionFactory.getCurrentSession().createQuery("delete from Reply where messageid = :ID").setParameter("ID", messageid);
		
	}

}
