package com.offcn.service;

import com.offcn.pojo.User;

public interface UserService {
    public User login(User user);
    public void insertUser(User user);
}
