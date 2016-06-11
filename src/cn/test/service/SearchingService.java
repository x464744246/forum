package cn.test.service;

import java.util.List;

import cn.test.model.Message;


public interface SearchingService {

		//通过标题查找，分页获得文章列表
		public List<Message> getMessagesByTitle(String keyword,int currentPage, int pageSize);

		//通过标题查找，得到文章总页数
		public int getPageCountByTitle(String keyword,int pageSize);
	
}
