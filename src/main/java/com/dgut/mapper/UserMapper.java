package com.dgut.mapper;

import com.dgut.domain.Order;
import com.dgut.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    //用户注册
    @Insert({"insert into user(name,id,username,sex,password,address,phone,birthday)value(#{name},#{id},#{username},#{sex},#{password},#{address},#{phone},#{birthday})"})
    void register(User user);
  
    //查询是否用户注册的用户名或id有重复
    @Select("select * from user where username =#{username} or id=#{id}")
    public User find(@Param("username") String username,@Param("id") String id);
  
    //管理员查询所有用户
    @Select("select username from user")
    public List<User> findAll();
  
    //管理员点击用户名进入用户主页
    @Select("select * from user LEFT JOIN `order` ON order.id=user.id where username=#{username}")
    @Results(value = {@Result(property = "id",column = "id"),@Result(property = "order.id",column = "id")})
    User findUserByUsername(String username);

    //管理员修改用户信息
    @Update("update user set name=#{name},sex=#{sex},password=#{password},id=#{id},birthday=#{birthday},address=#{address},"+
            "phone=#{phone},status=#{status},role=#{role} where username=#{username}")
    int RoleupdateUserByUsername(User user);

    //在user表里随机选取同时存在order表的数据(即有预约的用户),选取数量为公告栏公布的口罩数量
    @Select("SELECT * FROM USER LEFT JOIN `order` ON order.id=user.id WHERE order.id=user.id ORDER BY RAND() LIMIT #{num}")
    List<User> choose(Integer num);
  
    //在announcement表查询口罩的数量
    @Select("select num from announcement where id =(select max(id) from announcement)")
    int selectnum();
  
    //预约选择完成后清空order表
    @Delete("delete from `order`")
    int deleteOrder();
  
    //更新用户预约状态为未预约
    @Update("update user set status = 0")
    int updateStatu();
}
