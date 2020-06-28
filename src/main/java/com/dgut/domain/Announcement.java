package com.dgut.domain;
import org.springframework.stereotype.Component;
import java.util.Date;


@Component
public class Announcement {
    private Integer num; //口罩数量
    private String content; //公告信息
    private Date time; //发布时间
    private Integer id;
    private String title;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
