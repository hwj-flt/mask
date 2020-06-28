package com.dgut.service;
import com.dgut.domain.User;
import org.springframework.stereotype.Service;


import com.dgut.domain.User;

public interface UserService {
    void register(User user);
    public User find(String username,String id);
    //登录验证
    boolean checkLogin(String username, String password);
    //显示用户信息
    User showUserByUsername(String username);
    //修改用户信息
    boolean updateUser(User user);
    //预约口罩
    boolean orderMask(User user);
}
