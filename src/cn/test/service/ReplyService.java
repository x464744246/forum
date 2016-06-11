package cn.test.service;

import java.util.List;


import cn.test.model.Reply;

public interface ReplyService {
	
	//分页获得回复列表
	public List<Reply> getReplys(String messageid,int currentPage, int pageSize);

	//得到回复总页数
	public int getPageCount(String messageid,int pageSize);
	
	//添加回复
	public void addReply(String id,String messageid,String replymessage);
	
	public void deleteReply(String replyid);

}
