package cn.test.dao;

import java.util.List;

public interface ReplyDAO<T> {

	//通过文章id返回该文章的回复列表
	public List<T> getReplys(String messageid);

	//分页返回回复列表
	public List<T> getPageByReplys(String messageid,int currentPage, int pageSize);

	//返回总页数
	public int getPageCount(String messageid,int pageSize);
	
	//增加回复
	public void add(T t); 
	
	public void delete(T t); 
	
	public void deleteReplys(String messageid); 
	

}
