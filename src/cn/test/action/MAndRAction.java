package cn.test.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.test.model.MAndR;
import cn.test.model.Message;
import cn.test.model.User;
import cn.test.service.MAndRService;
import cn.test.service.ReplyService;
import cn.test.util.PublicValue;
@Scope("prototype")
@Controller("mAndRAction")
public class MAndRAction {
	private HttpServletRequest request = ServletActionContext.getRequest();

	int pagesize = PublicValue.PAGESIZE;

	@Autowired(required = false)
	@Qualifier("mAndRServiceImpl")
	MAndRService mAndRService;

	// 回复列表
	@Autowired(required = false)
	List<MAndR> reply;

	public List<MAndR> getReply() {
		return reply;
	}

	public void setReply(List<MAndR> reply) {
		this.reply = reply;
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
	// 回复页数及每页内容
		public String replypage() throws Exception {

			int cpage = 1;
			String id = ((User) ActionContext.getContext().getSession().get("u")).getId(); 
			int pagecount = mAndRService.getPageCount(id, pagesize) + 1;

			if (Integer.valueOf(request.getParameter("page").toString()) == -1) {
				cpage = pagecount;
			} else
				cpage = Integer.valueOf(request.getParameter("page").toString());

			reply = mAndRService.getReplys(id, cpage, pagesize);
	//	System.out.println("hhhhhhhhhhhhhh"+((MAndR)reply.get(1)).getTitle());
			if (cpage < 3)
				page = 3;
			else if (cpage > (pagecount - 2)&&pagecount>=5)
				page = pagecount - 2;
			else
				page = cpage;
			return "success";

		}
		
		public String delete() throws Exception {

			int cpage = 1;
			String id = ((User) ActionContext.getContext().getSession().get("u")).getId(); 
			mAndRService.deleteReply(request.getParameter("replyid").toString());
			reply = mAndRService.getReplys(id, cpage, pagesize);
			
			if (cpage < 3)
				page = 3;
			else
				page = cpage;
			return "success";

		}

}
