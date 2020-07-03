package com.dgut.domain;

public class Address {
    private String id;
    private String addd;
    private String name1;
    private String phone;
    private String full_add;
    private String user_id;
    private int provinceid;
    private int cityid;
    private int townid;

    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                ", addd='" + addd + '\'' +
                ", name1='" + name1 + '\'' +
                ", phone='" + phone + '\'' +
                ", full_add='" + full_add + '\'' +
                ", user_id='" + user_id + '\'' +
                ", provinceid=" + provinceid +
                ", cityid=" + cityid +
                ", townid=" + townid +
                '}';
    }

    public Address(String id, String addd, String name1, String phone, String full_add, String user_id, int provinceid, int cityid, int townid) {
        this.id = id;
        this.addd = addd;
        this.name1 = name1;
        this.phone = phone;
        this.full_add = full_add;
        this.user_id = user_id;
        this.provinceid = provinceid;
        this.cityid = cityid;
        this.townid = townid;
    }

    public Address() {
    }

    public int getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(int provinceid) {
        this.provinceid = provinceid;
    }

    public int getCityid() {
        return cityid;
    }

    public void setCityid(int cityid) {
        this.cityid = cityid;
    }

    public int getTownid() {
        return townid;
    }

    public void setTownid(int townid) {
        this.townid = townid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddd() {
        return addd;
    }

    public void setAddd(String addd) {
        this.addd = addd;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFull_add() {
        return full_add;
    }

    public void setFull_add(String full_add) {
        this.full_add = full_add;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
