package com.offcn.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.offcn.dao.UserDao;
import com.offcn.pojo.User;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	UserDao userDao;
	
	/*public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}*/


	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userDao.Login(user);
	}

	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		userDao.insertUser(user);
		String ss=null;
		System.out.println(ss.toString());
	}
   
}
