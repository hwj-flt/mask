package com.dgut.mapper;

import com.dgut.domain.User;
import org.apache.ibatis.annotations.*;
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

    /*
    根据用户名查找用户
     */
    @Select("select * from user LEFT JOIN `order` ON order.id=user.id where username=#{username}")
    @Results(value = {@Result(property = "id",column = "id"),@Result(property = "order.id",column = "id"),
            @Result(property = "order.state",column = "state")})
    User findUserByUsername(String username);
    /*
    根据用户名修改用户信息,role用户不能更改,管理员可以更改，用户进行口罩预约时可改status为1，执行操作前将不改的变量设置为null
     */
    @Update("<script>update user set name=#{name},sex=#{sex},password=#{password},id=#{id},birthday=#{birthday},address=#{address}," +
            "phone=#{phone}<if test='status != null '>,status=#{status}</if>" +
            "<if test='role != null '>,status=#{status}</if> where username=#{username}</script>")
    int updateUserByUsername(User user);
    /*
    预约成功后插入一条order.state=0 的数据
    */
    @Insert("Insert into `order` values(#{id},0)")
    int insertOrder(String id);
}
