package com.dgut.mapper;

import com.dgut.domain.Order;
import com.dgut.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    @Insert({"insert into user(name,id,username,sex,password,address,phone,birthday)value(#{name},#{id},#{username},#{sex},#{password},#{address},#{phone},#{birthday})"})
    void register(User user);

    @Select("select * from user where username =#{username} or id=#{id}")
    public User find(@Param("username") String username,@Param("id") String id);

    @Select("select username from user")
    public List<User> findAll();

    @Select("select * from order")
    public List<Order> findOrder();

    @Select("select * from user LEFT JOIN `order` ON order.id=user.id where username=#{username}")
    @Results(value = {@Result(property = "id",column = "id"),@Result(property = "order.id",column = "id")})
    User findUserByUsername(String username);

    @Update("update user set name=#{name},sex=#{sex},password=#{password},id=#{id},birthday=#{birthday},address=#{address},"+
            "phone=#{phone},status=#{status},role=#{role} where username=#{username}")
    int RoleupdateUserByUsername(User user);

//    @Select("select id from order RIGHT JOIN 'user' ON user.id=order.id ORDER BY rand() LIMIT 1")
//    @Results(value = {@Result(property = "id",column = "id"),@Result(property = "user.id",column = "id")})
//    User choose();
    //在user表里随机选取同时存在order表的数据(即有预约的用户),选取数量为公告栏公布的口罩数量
    @Select("SELECT * FROM USER LEFT JOIN `order` ON order.id=user.id WHERE order.id=user.id ORDER BY RAND() LIMIT #{num}")
    List<User> choose(Integer num);
    @Select("select num from announcement where id =(select max(id) from announcement)")
    int selectnum();
    //预约选择完成后清空order表
    @Delete("delete from `order`")
    int deleteOrder();
    @Update("update user set status = 0")
    int updateStatu();
}
