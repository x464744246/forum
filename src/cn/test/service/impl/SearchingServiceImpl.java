package cn.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.test.dao.MessageDAO;
import cn.test.model.Message;
import cn.test.service.SearchingService;

@Service("searchingServiceImpl")
public class SearchingServiceImpl implements SearchingService{
	@Autowired(required = false)
	@Qualifier("messageDAOImpl")
	private MessageDAO messagedao;
	
	@Override
	public List<Message> getMessagesByTitle(String keyword, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return  messagedao.getPageByMessagesByTitle(keyword, currentPage, pageSize);
	
	}

	@Override
	public int getPageCountByTitle(String keyword, int pageSize) {
		// TODO Auto-generated method stub
		return messagedao.getPageCountByTitle(keyword, pageSize);
	}

}
