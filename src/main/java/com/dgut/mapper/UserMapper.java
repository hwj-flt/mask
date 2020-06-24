package com.dgut.mapper;

import com.dgut.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    @Insert({"insert into user(name,id,username,sex,password,address,phone)value(#{name},#{id},#{username},#{sex},#{password},#{address},#{phone})"})
    void register(User user);

    @Select("select * from user where username =#{username} or id=#{id}")
    public User find(@Param("username") String username,@Param("id") String id);
}
