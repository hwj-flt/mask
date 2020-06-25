package com.dgut.mapper;

import com.dgut.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMapper {
    /*
    管理员页面用户管理，查找所有用户信息
     */
    @Select("select * from user")
    List<User> findAllUser();
    /*
    根据用户名查找用户
     */
    @Select("select * from user where username=#{username}")
    User findUserByUsername(String username);
    /*
    管理员删除用户信息
     */
    @Delete("delete from user where id=#{id}")
    int deleteUserById(String id);
    /*
    根据用户名修改用户信息,role、status用户不能更改
     */
    @Update("update user set name=#{name},sex=#{sex},password=#{password},id=#{id},birthday=#{birthday},address=#{address},"+
            "phone=#{phone} where username=#{username}")
    int updateUserByUsername(User user);
}
