package cn.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.test.dao.MAndRDAO;
import cn.test.dao.ReplyDAO;
import cn.test.model.MAndR;
import cn.test.model.Reply;
import cn.test.service.MAndRService;
@Service("mAndRServiceImpl")
public class MAndRServiceImpl implements MAndRService{
	@Autowired(required = false)
	@Qualifier("replyDAOImpl")
	private ReplyDAO replydao;
	
	@Autowired(required = false)
	@Qualifier("mAndRDAOImpl")
	private MAndRDAO mAndRdao;

	@Override
	public List<MAndR> getReplys(String id, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		
		return mAndRdao.getRelysByID(id, currentPage, pageSize);
	}

	@Override
	public int getPageCount(String id, int pageSize) {
		// TODO Auto-generated method stub
		return mAndRdao.getPageCount(id, pageSize);
	}

	@Override
	public void deleteReply(String replyid) {
		// TODO Auto-generated method stub
		Reply r = new Reply();
		r.setReplyid(replyid);
		replydao.delete(r);
	}

}
