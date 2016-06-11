package cn.test.dao;

import java.util.List;

public interface MessageDAO<T> {
	
	//返回所有文章列表
	public List<T> getAllMessages() ;
	
	//添加文章
	public void addMessage(T t) ;
	
	//分页返回所有文章列表
	public List<T> getPageByMessages(int currentPage, int pageSize) ;
	
	//通过每页大小返回总页数
	public int getPageCount(int pageSize) ;
	
	//通过id返回文章
	public T getById(String id);
	
	public void deleteById(T t);
	
	//根据标题分页返回所有文章列表
	public List<T> getPageByMessagesByTitle(String keyword, int currentPage, int pageSize) ;
	
	//根据标题通过每页大小返回总页数
	public int getPageCountByTitle(String keyword, int pageSize) ;
	 
}
