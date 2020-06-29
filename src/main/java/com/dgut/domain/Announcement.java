package com.dgut.domain;


import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class Announcement {
    private Integer id; //公告序号
    private Integer num; //口罩数量
    private String context; //公告信息
    private Date time; //发布时间
    private Date deadline;//截止时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

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
                "id=" + id +
                ", num=" + num +
                ", context='" + context + '\'' +
                ", time=" + time +
                ", deadline=" + deadline +
                '}';
    }
}
