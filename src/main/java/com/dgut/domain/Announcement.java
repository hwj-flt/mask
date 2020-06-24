package com.dgut.domain;

import java.util.Date;

public class Announcement {
    private Integer num;
    private String context;
    private Date time;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "num=" + num +
                ", context='" + context + '\'' +
                ", time=" + time +
                '}';
    }
}
