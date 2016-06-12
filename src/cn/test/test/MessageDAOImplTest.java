package cn.test.test;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:/WebContent/WEB-INF/applicationContext*.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class MessageDAOImplTest {

	@Autowired
	public SessionFactory sessionFactory;
	
	@Before
	public void setUp() throws Exception {
		}

	/*@SpringBean("sessionFactory")
	SessionFactory sessionfactory;*/
	
	@Test
	public void testGetAllMessages() {
	
		Session s = sessionFactory.getCurrentSession();
		assertNotNull(s);
		//List list = sessionfactory.getCurrentSession().createQuery("from Message").list();
		//for(int i =0; i < list.size();i++)
		//System.out.println(((Message)list.get(i)).getMessage());
		//assertNotNull(list);
	}

}
