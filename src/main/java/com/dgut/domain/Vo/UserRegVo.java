package com.dgut.domain.Vo;

public class UserRegVo {
    private String username;
    private String name;
    private String sex;
    private String password;
    private String phone;
    private String yzm;
    private String tureYZM;

    @Override
    public String toString() {
        return "UserRegVo{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", yzm='" + yzm + '\'' +
                ", tureYZM='" + tureYZM + '\'' +
                '}';
    }

    public UserRegVo(String username, String name, String sex, String password, String phone, String yzm, String tureYZM) {
        this.username = username;
        this.name = name;
        this.sex = sex;
        this.password = password;
        this.phone = phone;
        this.yzm = yzm;
        this.tureYZM = tureYZM;
    }

    public UserRegVo() {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getYzm() {
        return yzm;
    }

    public void setYzm(String yzm) {
        this.yzm = yzm;
    }

    public String getTureYZM() {
        return tureYZM;
    }

    public void setTureYZM(String tureYZM) {
        this.tureYZM = tureYZM;
    }
}
