package com.dgut.mapper;

import com.dgut.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMapper {
    /*
    根据用户名查找用户
     */
    @Select("select * from user LEFT JOIN `order` ON order.id=user.id where username=#{username}")
    @Results(value = {@Result(property = "id",column = "id"),@Result(property = "order.id",column = "id")})
    User findUserByUsername(String username);
    /*
    根据用户名修改用户信息,role用户不能更改,管理员可以更改，用户进行口罩预约时可改status为1，执行操作前将不改的变量设置为null
     */
    @Update("<script>update user set password=#{password},id=#{id}" +
            "<if test='name != null '>,name=#{name}</if>" +
            "<if test='sex != null '>,sex=#{sex}</if>" +
            "<if test='birthday != null '>,birthday=#{birthday}</if>" +
            "<if test='address != null '>,address=#{address}</if>" +
            "<if test='phone != null '>,phone=#{phone}</if>" +
            "<if test='status != null '>,status=#{status}</if>" +
            "<if test='role != null '>,status=#{status}</if> " +
            "where username=#{username}</script>")
    int updateUserByUsername(User user);
    /*
    预约成功后插入一条order数据
    */
    @Insert("Insert into `order` values(#{id})")
    int insertOrder(String id);
}
