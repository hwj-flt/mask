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

    public User find(String username,String id) {
        return userMapper.find(username, id);
    }

    public void register(User user) {
            userMapper.register(user);
    }

    public List<User> findAll(){return userMapper.findAll();}

    public List<Order> findOrder(){return userMapper.findOrder();}
    public User findUserByUsername(String username){return userMapper.findUserByUsername(username);}
    public boolean RoleupdateUserByUsername(User user){return userMapper.RoleupdateUserByUsername(user) > 0;}
    public List<User> choose(Integer num){return userMapper.choose(num);}
    public int selectnum(){return userMapper.selectnum();}
    public int deleteOrder(){return userMapper.deleteOrder();}
    public int updateStatu(){return userMapper.updateStatu();}

}
