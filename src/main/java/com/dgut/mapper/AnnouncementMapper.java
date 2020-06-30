package com.dgut.mapper;

import com.dgut.domain.Announcement;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AnnouncementMapper {
    //展示最新公告内容
    @Select("select * from announcement where id =(select max(id) from announcement)")
    //展示历史公告内容
    public Announcement show();
    @Select("select * from announcement")
    public List<Announcement> showall();
    //更新公告内容
    @Insert("insert into announcement(num,content,time,deadline)value(#{num},#{content},#{time},#{deadline})")
    public void insert(Announcement announcement);
    //查截止时间
    @Select("select deadline from announcement where id=(select max(id) from announcement)")
    public Date findDeadline();
}
