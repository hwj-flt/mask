package com.dgut.mapper;

import com.dgut.domain.Announcement;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

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

}
