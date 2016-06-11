package cn.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import cn.test.dao.ReplyDAO;
import cn.test.model.Reply;
import cn.test.service.ReplyService;

@Service("replyServiceImpl")
public class ReplyServiceImpl implements ReplyService{
	@Autowired(required = false)
	@Qualifier("replyDAOImpl")
	private ReplyDAO replydao;


	@Override
	public List<Reply> getReplys(String messageid,int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		
		return replydao.getPageByReplys(messageid,currentPage, pageSize);
	}

	@Override
	public int getPageCount(String messageid,int pageSize) {
		// TODO Auto-generated method stub
		return replydao.getPageCount(messageid,pageSize);
	}

	@Override
	public void addReply(String id, String messageid, String replymessage) {
		// TODO Auto-generated method stub
		Reply reply = new Reply();
		reply.setId(id);
		reply.setMessageid(messageid);
		reply.setReplymessage(replymessage);
		replydao.add(reply);
	}

	@Override
	public void deleteReply(String replyid) {
		// TODO Auto-generated method stub
		Reply reply = new Reply();
		reply.setReplyid(replyid);
		replydao.delete(reply);
		
	}

}
