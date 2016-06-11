package cn.test.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.test.dao.MessageDAO;
import cn.test.dao.impl.MessageDAOImpl;
import cn.test.model.Message;
import cn.test.model.Reply;
@Service
@Transactional
public class Test {
	
//ÃÌº”≤‚ ‘ ˝æ›
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BeanFactory bf = new FileSystemXmlApplicationContext("/WebContent/WEB-INF/applicationContext*.xml");//spring≈‰÷√Œƒº˛Œª÷√
		SessionFactory sf = (SessionFactory) bf.getBean("sessionFactory");
		Session s = sf.openSession();
	     s.beginTransaction();
		java.util.Date ud = new java.util.Date();
		for (int i = 1000; i < 2000; i++) {
		/*	Message m = new Message();
			m.setCreatedate(new java.sql.Date(ud.getTime()) );
			m.setId("1");
			m.setMessage("π˛π˛π˛π˛π˛π˛π˛π˛π˛π˛");
			//m.setMessageid(i + "");
			m.setTitle("≤‚ ‘" + i);
			s.save(m);*/
			Reply r = new Reply();
			r.setCreatedate(new java.sql.Timestamp(ud.getTime()) );
			r.setId("1");
			r.setMessageid("1");
			r.setReplymessage("π˛π˛π˛π˛π˛π˛π˛π˛π˛π˛");
			s.save(r);
			
		

		}
		s.getTransaction().commit();
	}

}
