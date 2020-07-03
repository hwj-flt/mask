package com.dgut.domain.Vo;

public class UserNewPawVo {
    private String id;
    private String password;
    private String newPaw;

    public UserNewPawVo(String id, String password, String newPaw) {
        this.id = id;
        this.password = password;
        this.newPaw = newPaw;
    }

    public UserNewPawVo() {
    }

    @Override
    public String toString() {
        return "userNewPawVo{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", newPaw='" + newPaw + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPaw() {
        return newPaw;
    }

    public void setNewPaw(String newPaw) {
        this.newPaw = newPaw;
    }
}
