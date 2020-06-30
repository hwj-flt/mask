package com.dgut.service;
import com.dgut.domain.Order;
import com.dgut.domain.User;
import java.util.List;

import com.dgut.domain.User;

public interface UserService {
    void register(User user);
    public User find(String username,String id);
    public List<User> findAll();
    public List<Order> findOrder();
    public User findUserByUsername(String username);
    public boolean RoleupdateUserByUsername(User user);
    public List<User> choose(Integer num);
    public int selectnum();
    public int deleteOrder();
    public int updateStatu();
    //登录验证
    boolean checkLogin(String username, String password);
    //显示用户信息
    User showUserByUsername(String username);
    //修改用户信息
    boolean updateUser(User user);
    //预约口罩
    boolean orderMask(User user);
}
