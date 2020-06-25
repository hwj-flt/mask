package com.dgut.mapper;

import com.dgut.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserMapper {
    @Insert({"insert into user(name,id,username,sex,password,address,phone)value(#{name},#{id},#{username},#{sex},#{password},#{address},#{phone})"})
    void register(User user);

    @Select("select * from user where username =#{username} or id=#{id}")
    public User find(@Param("username") String username,@Param("id") String id);
    /*
    管理员页面用户管理，查找所有用户信息
     */
    @Select("select * from user")
    public List<User> findAllUser();
    /*
    根据用户名查找用户
     */
    @Select("select * from user where username=#{username}")
    public User findUserByUsername(String username);
    /*
    用户注册成功，增加用户信息
     */
    @Insert("insert into user values(#{username},#{name},#{sex},#{password},#{id},#{address},#{phone},#{role},#{status})")
    public int addUser(User user);
    /*
    管理员删除用户信息
     */
    @Delete("delete from user where id=#{id}")
    public int deleteUserById(String id);
    /*
    根据身份证号修改用户信息
     */
    @Update("update user set username=#{username},name=#{name},sex=#{sex},password=#{password},phone=#{phone},role=#{role},status=#{status} where id=#{id}")
    public int updateUserById(User user);
}
