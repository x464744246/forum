package cn.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.test.dao.UserDAO;
import cn.test.model.User;
import cn.test.service.RegistService;

@Service("registServiceImpl")
public class RegistServiceImpl implements RegistService{
	@Autowired
	@Qualifier("userDAOImpl")
	UserDAO userdao;

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		this.userdao.addUser(user);
		
	}

	@Override
	public User getUser(User user) {
		// TODO Auto-generated method stub
		return (User)this.userdao.getById(user.getId());
	}

}
