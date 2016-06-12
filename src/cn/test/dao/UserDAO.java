package cn.test.dao;

import java.util.List;

public interface UserDAO<T> {

	// 查找用户
	T getById(String id);

	// id查找用户
	public List<T> getUsersById(String id);

	// 添加用户
	public void addUser(T t);

	// 修改密码
	public void updateUser(T t);
}
