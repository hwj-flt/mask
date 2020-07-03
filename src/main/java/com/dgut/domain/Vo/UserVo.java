package com.dgut.domain.Vo;

public class UserVo {
    private String id;
    private String name;

    @Override
    public String toString() {
        return "UserVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public UserVo(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserVo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
