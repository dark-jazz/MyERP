package com.offcn.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.offcn.pojo.User;
import com.offcn.service.UserService;

public class UserAction implements SessionAware{
   
	Map<String, Object> session;
	@Resource
	UserService userService;
	User user;
	
	@Action(value="login",results={@Result(name="succ",location="/index.jsp"),@Result(name="fail",location="/login.jsp")})
	public String Login(){
    	User loginuser=userService.login(user);
    	if(loginuser!=null){
    		session.put("user", loginuser);
    	}else{
    		return "fail";
    	}
	   return "succ";
    }
	
	@Action(value="insertUser",results={@Result(name="succ",location="/index.jsp"),@Result(name="fail",location="/login.jsp")})
	public String insertUser(){
		User user=new User();
		user.setUsername("lih");
		user.setPassword("111");
		userService.insertUser(user);
		return "succ";
	}
	
	/* public UserService getUserService() {
			return userService;
		}

		public void setUserService(UserService userService) {
			this.userService = userService;
		}*/

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		@Override
		public void setSession(Map<String, Object> arg0) {
			// TODO Auto-generated method stub
			this.session=arg0;
		}
	
}
