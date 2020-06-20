package com.dgut.domain;

public class Order {
    private Integer id; //
    private Integer state; //

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
