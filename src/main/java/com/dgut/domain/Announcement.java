package com.dgut.domain;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class Announcement {
    private Integer num;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private Date time;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private Date deadline;
    private Integer id;
    private String title;


    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Integer getId() {
        return id;
    }
  
    public void setId(Integer id) {
        this.id = id;
    }
  
    public Announcement() {

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Announcement(Integer num, String content, Date time, Integer id, String title) {
        this.num = num;
        this.content = content;
        this.time = time;
        this.id = id;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "num=" + num +
                ", content='" + content + '\'' +
                ", time=" + time +
                ", id=" + id +
                ", title='" + title + '\'' +
                '}';

    }

    public Announcement() {
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
                ", content='" + content + '\'' +
                ", time=" + time +
                ", deadline=" + deadline +
                ", id=" + id +
                '}';
}
