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
    @Override
    public boolean checkLogin(String username,String password) {
        User user = userMapper.findUserByUsername(username);
        return password.equals(user.getPassword());
    }

    @Override
    public User showUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    @Override
    public boolean updateUser(User user) {
        return userMapper.updateUserByUsername(user) > 0;
    }

    @Override
    public boolean orderMask(User user) {
        user.setStatus(1);
        user.setRole(null);
        return updateUser(user) && userMapper.insertOrder(user.getId()) > 0;
    }
}
