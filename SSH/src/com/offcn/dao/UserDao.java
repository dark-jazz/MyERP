package com.offcn.dao;

import com.offcn.pojo.User;

public interface UserDao {
   public User Login(User user);
   public void insertUser(User user);
}
