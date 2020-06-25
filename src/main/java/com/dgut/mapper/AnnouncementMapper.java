package com.dgut.mapper;

import com.dgut.domain.Announcement;
<<<<<<< HEAD
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
=======
>>>>>>> master
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
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
    @Insert("insert into announcement(num,content,time)value(#{num},#{content},#{time})")
    public void insert(Announcement announcement);
=======
@Repository
public interface AnnouncementMapper {
    /*
    查找公告信息
     */
    @Select("select * from announcement")
    public Announcement findAll();
    /*
    修改公告栏信息
     */
    @Update("update announcement set num=#{num},context=#{context},time=#{time}")
    public int updateAnno(Announcement announcement);

>>>>>>> master
}
