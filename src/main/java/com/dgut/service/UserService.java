package com.dgut.service;
import com.dgut.domain.User;
import org.springframework.stereotype.Service;


public interface UserService {
    void register(User user);
    public User find(String username,String id);
    //登录验证
    public boolean checkLogin(String username,String password);
}
