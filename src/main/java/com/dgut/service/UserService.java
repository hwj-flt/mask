package com.dgut.service;

import com.dgut.domain.Order;
import com.dgut.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    //用户注册
    void register(User user);
    //查询是否用户注册的用户名或id有重复
    public User find(String username, String id, String phone);
    //管理员查询所有用户
    public List<User> findAll();
    //管理员点击用户名进入用户主页
    public User findUserByUsername(String username);

    public User findUserByUserId(String id);

    public User findUserByPhone(String phone);
    //管理员修改用户信息
    public boolean RoleupdateUserByUsername(User user);
    //在user表里随机选取同时存在order表的数据(即有预约的用户),选取数量为公告栏公布的口罩数量
    public List<User> choose(Integer num);
    //在announcement表查询口罩的数量
    public int selectnum();
    //预约选择完成后清空order表
    public int deleteOrder();
    //更新用户预约状态为未预约
    public int updateStatu();
    //登录验证
    boolean checkLogin(String username, String password);
    //显示用户信息
    User showUserByUsername(String username);
    //修改用户信息
    boolean updateUser(User user);
    //预约口罩
    boolean orderMask(User user);
    public int addOrder(Order order);
}
