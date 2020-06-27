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
    @Results(value = {@Result(property = "id",column = "id"),@Result(property = "order.id",column = "id"),
        @Result(property = "order.state",column = "state")})
    User findUserByUsername(String username);
    /*
    根据用户名修改用户信息,role用户不能更改
     */
    @Update("update user set name=#{name},sex=#{sex},password=#{password},id=#{id},birthday=#{birthday},address=#{address},"+
            "phone=#{phone},status=#{status} where username=#{username}")
    int updateUserByUsername(User user);
    /*
    预约成功后插入一条order.state=0 的数据
    */
    @Insert("Insert into `order` values(#{id},0)")
    int insertOrder(String id);
}
