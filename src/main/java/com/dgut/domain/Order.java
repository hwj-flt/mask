package com.dgut.domain;

import org.springframework.stereotype.Component;

@Component
public class Order {
    private String id; //User表的id的外键

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                '}';
    }
}
