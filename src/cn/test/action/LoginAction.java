package cn.test.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.test.model.Message;
import cn.test.model.User;
import cn.test.service.*;
import cn.test.util.MD5Util;

@Scope("prototype")
@Controller("loginAction")
public class LoginAction extends ActionSupport {

	// private HttpServletRequest request = ServletActionContext.getRequest();

	// 登陆事物
	@Autowired(required = false)
	@Qualifier("loginServiceImpl")
	LoginService loginService;

	// 用户，验证后加入session
	@Autowired(required = false)
	User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// 文章列表
	@Autowired(required = false)
	List<Message> message;

	public List<Message> getMessage() {
		return message;
	}

	public void setMessage(List<Message> message) {
		this.message = message;
	}

	// 初始页书，返回的是3，为了前端排版（页面固定是5页）
	@Autowired(required = false)
	public int page;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	// 登陆校验
	public String execute() throws Exception {

		this.user.setPassword(MD5Util.string2MD5(this.user.getPassword()));
		user = loginService.loginCheck(this.user);
		if (user != null) {
			if (user.getLevel().equals("admin")) {

				ActionContext.getContext().getSession().put("u", this.user);
				message = loginService.getMessages(1, 10);
				page = 3;

				return "admin";
			} else if (user.getLevel().equals("user"))
				return "user";
			else
				return "WrongPassword";
		} else
			return "WrongPassword";

	}

	// 返回登陆界面
	public String returnLogin() throws Exception {

		ActionContext.getContext().getSession().put("u", null);
		return "return";

	}

	public String out() throws Exception {

		// request.getSession().invalidate();
		return "out";

	}
}
