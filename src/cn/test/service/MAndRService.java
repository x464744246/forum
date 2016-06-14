package cn.test.service;

import java.util.List;

import cn.test.model.MAndR;
import cn.test.model.Reply;

public interface MAndRService {
	
	
	//分页获得回复列表
	public List<MAndR> getReplys(String id,int currentPage, int pageSize);

	//得到回复总页数
	public int getPageCount(String id,int pageSize);
	
	public void deleteReply(String replyid);
	

}
