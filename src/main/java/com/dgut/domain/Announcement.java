package com.dgut.domain;


import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class Announcement {
    private Integer num; //口罩数量
    private String context; //公告信息
    private Date time; //发布时间

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
