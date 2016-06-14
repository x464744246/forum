package cn.test.dao;

import java.util.List;

public interface UserDAO<T> /*extends BaseDAO<T>*/{

	// 查找用户
	public T get(T t);

	// id查找用户
	public List<T> getUsersById(String id);

	// 添加用户
	public void addUser(T t);

	// 修改密码
	public void updateUser(T t);
}
