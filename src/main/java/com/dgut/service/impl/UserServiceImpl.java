package com.dgut.service.impl;

import com.dgut.domain.User;
import com.dgut.mapper.UserMapper;
import com.dgut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public User find(String username,String id) {
        return userMapper.find(username, id);
    }

    public void register(User user) {
            userMapper.register(user);
    }


}
