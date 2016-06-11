package cn.test.service;

import java.util.List;

import cn.test.model.Message;
import cn.test.model.User;

public interface LoginService {
	
	//登陆校验，返回user对象放入session
    public User loginCheck(User user);
    
    //得到文章列表，用于登陆后的初次跳转
    public List<Message> getMessages(int currentPage, int pageSize ) ;
    
    //得到总页数，用于登陆后的初次跳转
    public int getPageCount(int pageSize );
}
