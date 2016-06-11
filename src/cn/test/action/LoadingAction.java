package cn.test.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.test.dao.*;
import cn.test.model.User;
import cn.test.service.*;

@Scope("prototype")
@Controller("loadingAction")
public class LoadingAction extends ActionSupport {
	@Autowired(required = false) // @Qualifier("userDAOImpl")
	private UserDAO userdao;
	
	private Map<String, Object> jsonResult; 
	public Map<String, Object> getJsonResult() {
		return jsonResult;
	}
	public void setJsonResult(Map<String, Object> jsonResult) {
		this.jsonResult = jsonResult;
	}
	
	
	public String execute() throws Exception {
/*
		Map<String, Object> map = new HashMap<String, Object>();
		String status = null;
		try {
			
				List<User> list = new ArrayList<User>() ;
				list.add((User)this.userdao.getById("1"));
System.out.println("hahahahahahahahahahahaha");
				//(String)ActionContext.getContext().getSession().get("userid")
				if (list.size() > 0) {
					 status = "1";
					map.put("users", list);
				} else {
					status = "null";
				}
			
			map.put("status", status);
			jsonResult = map;
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//return null;
		return "success";
	}
}
/*
 * else if (loginService.loginCheck(this.user).equals("user")) return "user";
 * else if (loginService.loginCheck(this.user).equals("WrongPassword")) return
 * "WrongPassword"; else return "error";
 */
/*
 * System.out.println("hhhhhhhhhhhhhhhhhhh"+this.user.getId());
 * System.out.println("hhhhhhhhhhhhhhhhhhh"+loginService.loginCheck(this.user));
 * if (loginService.loginCheck(this.user).equals("admin"))
 */