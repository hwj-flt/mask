package com.dgut.domain;

public class Order {
    private String id;
    private String addrid;

    public String getAddrid() {
        return addrid;
    }

    public void setAddrid(String addrid) {
        this.addrid = addrid;
    }

    public Order(String id, String addrid) {
        this.id = id;
        this.addrid = addrid;
    }

    public Order() {
    }

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
                ", addrid='" + addrid + '\'' +
                '}';
    }
}
