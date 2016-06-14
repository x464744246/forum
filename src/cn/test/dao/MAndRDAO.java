package cn.test.dao;

import java.util.List;

public interface MAndRDAO<T> {

	// 分页返回我的回复列表p
	public List<T> getRelysByID(String id, int currentPage, int pageSize);

	// 返回总页数
	public int getPageCount(String id, int pageSize);

}
