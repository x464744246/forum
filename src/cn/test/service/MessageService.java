package cn.test.service;

import java.util.List;

import cn.test.model.Message;

public interface MessageService {

	//分页得到文章列表
	public List<Message> getMessages(int currentPage, int pageSize);

	//得到总页数
	public int getPageCount(int pageSize);
	
	//通过messageid得到文章
	public Message getMessage(String messageid);
	
	public void deleteMessage(String messageid);
	
	public void addMessage(String title,String article ,String id);

}
