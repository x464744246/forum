package cn.test.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.test.dao.*;
import cn.test.model.Message;
import cn.test.model.User;
import cn.test.service.LoginService;
@Service("loginServiceImpl")
public class LoginServiceImpl implements LoginService{
    @Autowired(required = false)
    @Qualifier("userDAOImpl")
	private UserDAO userdao ;
    
    @Autowired(required = false)
    @Qualifier("messageDAOImpl")
   	private MessageDAO messagedao ;

 /*   @Autowired(required = false)
    @Qualifier("replyDAOImpl")
   	private ReplyDAO replydao ;*/
    
	public User loginCheck(User user) {
        
		User u = (User)this.userdao.get(user);
		System.out.println("333");
		if (user.getPassword().equals(u.getPassword())) {
	
			
				return u;
		} else

			return null;

	}
	public List<Message> getMessages(int currentPage, int pageSize) {
		List list = messagedao.getPageByMessages(currentPage, pageSize);
	/*	Iterator iterator = list.iterator();
		int i = 0;
		while (iterator.hasNext()) {

			Message message = (Message)iterator.next();
			message.setReply(replydao.getReplys(message.getMessageid()));
			list.set(i,message);
			i++;

		}*/
		return list;
	}
	@Override
	public int getPageCount(int pageSize) {
		// TODO Auto-generated method stub
		
		return messagedao.getPageCount(pageSize);
	}
}
