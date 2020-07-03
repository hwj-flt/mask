package com.dgut.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class User {
    private String username; //用户名,唯一,用于登录
    private String name; //真实姓名
    private String sex; //性别
    private String password; //密码
    private String id; //身份证号码,唯一
    private String phone; //手机号码
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private Date birthday;
    private Integer role; //管理员或者普通用户
    private Integer status; //预约状态

    public User(String username, String name, String sex, String password, String id, String phone, Date birthday, Integer role, Integer status) {
        this.username = username;
        this.name = name;
        this.sex = sex;
        this.password = password;
        this.id = id;
        this.phone = phone;
        this.birthday = birthday;
        this.role = role;
        this.status = status;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", password='" + password + '\'' +
                ", id='" + id + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday=" + birthday +
                ", role=" + role +
                ", status=" + status +
                '}';
    }
}
