package com.dgut.service.impl;

import com.dgut.domain.Order;
import com.dgut.domain.User;
import com.dgut.mapper.UserMapper;
import com.dgut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User find(String username,String id) {
        return userMapper.find(username, id);
    }

    @Override
    public void register(User user) {
            userMapper.register(user);
    }

    @Override
    public List<User> findAll(){
        return userMapper.findAll();
    }

    @Override
    public User findUserByUsername(String username){
        return userMapper.findUserByUsername(username);
    }

    @Override
    public boolean RoleupdateUserByUsername(User user){
        return userMapper.RoleupdateUserByUsername(user) > 0;
    }

    @Override
    public List<User> choose(Integer num){
        return userMapper.choose(num);
    }

    @Override
    public int selectnum(){
        return userMapper.selectnum();
    }

    @Override
    public int deleteOrder(){
        return userMapper.deleteOrder();
    }

    @Override
    public int updateStatu(){
        return userMapper.updateStatu();
    }

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
