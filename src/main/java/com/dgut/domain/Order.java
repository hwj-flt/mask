package com.dgut.domain;


import org.springframework.stereotype.Component;

@Component
public class Order {
    private Integer id; //User表的id的外键
    private Integer state; //判断预约成功与否

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
