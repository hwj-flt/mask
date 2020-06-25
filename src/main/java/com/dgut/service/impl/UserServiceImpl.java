package com.dgut.service.impl;

import com.dgut.domain.User;
import com.dgut.mapper.UserMapper;
import com.dgut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public User find(String username,String id) {
        return userMapper.find(username, id);
    }

    public void register(User user) {
            userMapper.register(user);
    }
    @Override
    public boolean checkLogin(String username,String password) {
        User user = userMapper.findUserByUsername(username);
        if(password.equals(user.getPassword())){
            return true;
        }
        return false;
    }
}
