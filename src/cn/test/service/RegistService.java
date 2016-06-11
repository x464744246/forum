package cn.test.service;

import cn.test.model.User;

public interface RegistService {
   
	//添加用户
	public void addUser(User user);
	
	//得到用户
	public User getUser(User user);
}
