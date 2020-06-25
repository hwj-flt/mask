package com.dgut.domain;

<<<<<<< HEAD
import java.util.Date;

public class Announcement {
    private Integer num;
    private String content;
    private Date time;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
=======

import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class Announcement {
    private Integer num; //口罩数量
    private String context; //公告信息
    private Date time; //发布时间
>>>>>>> master

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

<<<<<<< HEAD
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
=======
    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
>>>>>>> master
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
<<<<<<< HEAD
                ", content='" + content + '\'' +
                ", time=" + time +
                ", id=" + id +
=======
                ", context='" + context + '\'' +
                ", time=" + time +
>>>>>>> master
                '}';
    }
}
