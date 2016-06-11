package cn.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.test.dao.MessageDAO;
import cn.test.dao.ReplyDAO;
import cn.test.model.Message;
import cn.test.service.MessageService;

@Service("messageServiceImpl")
public class MessageServiceImpl implements MessageService {
	@Autowired(required = false)
	@Qualifier("messageDAOImpl")
	private MessageDAO messagedao;

	@Autowired(required = false)
	@Qualifier("replyDAOImpl")
	private ReplyDAO replydao;
	
	
	public List<Message> getMessages(int currentPage, int pageSize) {
		List list = messagedao.getPageByMessages(currentPage, pageSize);

		return list;
	}

	@Override
	public int getPageCount(int pageSize) {
		// TODO Auto-generated method stub

		return messagedao.getPageCount(pageSize);
	}

	@Override
	public Message getMessage(String messageid) {
		// TODO Auto-generated method stub
		return (Message)messagedao.getById(messageid);
	}

	@Override
	public void deleteMessage(String messageid) {
		// TODO Auto-generated method stub
		Message m = new Message();
		m.setMessageid(messageid);
		messagedao.deleteById(m);
		replydao.deleteReplys(messageid);
	}

	@Override
	public void addMessage(String title, String article,String id) {
		// TODO Auto-generated method stub
		Message message = new Message();
		message.setId(id);
		message.setMessage(article);
		message.setTitle(title);
		messagedao.addMessage(message);
		
	}

}
