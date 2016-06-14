package cn.test.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.test.model.Message;
import cn.test.model.User;
import cn.test.service.*;
import cn.test.util.PublicValue;

@Scope("prototype")
@Controller("searchingAction")
public class SearchingAction extends ActionSupport {

	private HttpServletRequest request = ServletActionContext.getRequest();
	
	// 查找事物
	@Autowired(required = false)
	@Qualifier("searchingServiceImpl")
	SearchingService searchingService;
	
	// 每页列表大小
	int pagesize = PublicValue.PAGESIZE;

	// 文章列表
	@Autowired(required = false)
	List<Message> message;

	public List<Message> getMessage() {
		return message;
	}

	public void setMessage(List<Message> message) {
		this.message = message;
	}

	// 前端返回的跳转页码，传过去的是分页内容
	@Autowired(required = false)
	public int page;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	//关键字查询
	String keyword;
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	// 查询，略还未具体实现(已经完成中文转码)
	public String title() throws Exception {

		System.out.println("123123" + java.net.URLDecoder.decode(request.getParameter("keyword"), "utf-8"));

		String keyword = java.net.URLDecoder.decode(request.getParameter("keyword"), "utf-8");
		this.keyword= keyword;
		int cpage = 1;
		int pagecount = searchingService.getPageCountByTitle(keyword,pagesize) + 1;
		if (Integer.valueOf(request.getParameter("page").toString()) == -1) {
			cpage = pagecount;
		} else
			cpage = Integer.valueOf(request.getParameter("page").toString());

		message = searchingService.getMessagesByTitle(keyword, cpage, pagesize);
		if (cpage < 3)
			page = 3;
		else if (cpage > (pagecount - 2)&&pagecount>=5)
			page = pagecount - 2;
		else
			page = cpage;
		return "success";
	

	}
}
