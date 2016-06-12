package cn.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.test.dao.UserDAO;
import cn.test.model.User;
import cn.test.service.PasswordService;
import cn.test.util.MD5Util;

@Service("passwordServiceImpl")
public class PasswordServiceImpl implements PasswordService {
	@Autowired
	@Qualifier("userDAOImpl")
	UserDAO userdao;

	@Override
	public Boolean passwordChange(User u, String pwd1, String pwd2) {
		// TODO Auto-generated method stub
		String pwd = u.getPassword();

		System.out.println(pwd);
		pwd1 = MD5Util.string2MD5(pwd1);
		if (pwd.equals(pwd1)){
			System.out.println("tantantnatnantnatntan");
			pwd2 = MD5Util.string2MD5(pwd2);
			u.setPassword(pwd2);
			userdao.updateUser(u);
			return true;
			}
		else
			return false;
	}

}
