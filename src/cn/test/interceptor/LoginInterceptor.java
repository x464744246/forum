package cn.test.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import cn.test.model.User;

public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		User u = (User) ActionContext.getContext().getSession().get("u");
		if (u == null)
			return "logincheck_fail";
		else
			return invocation.invoke();
	}

}
