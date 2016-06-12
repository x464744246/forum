package cn.test.action;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.test.model.User;
import cn.test.service.PasswordService;
import cn.test.util.MD5Util;

@Scope("prototype")
@Controller("passwordChangeAction")
public class PasswordChangeAction {

	@Autowired(required = false)
	@Qualifier("passwordServiceImpl")
	PasswordService passwordService;

	// æ…√‹¬Î
	String pwd1;

	public String getPwd1() {
		return pwd1;
	}

	public void setPwd1(String pwd1) {
		this.pwd1 = pwd1;
	}

	// –¬√‹¬Î
	String pwd2;

	public String getPwd2() {
		return pwd2;
	}

	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}

	public String returncheck() throws Exception {

		return "success";

	}

	public String changecheck() throws Exception {

		User u = (User) ActionContext.getContext().getSession().get("u");
		System.out.println("222"+u.getId()+pwd1+pwd2);
		if (passwordService.passwordChange(u,pwd1, pwd2)==true)
			return "success";
		else
			return "fail";

	}
}
