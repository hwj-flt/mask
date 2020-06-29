package com.dgut.mapper;

import com.dgut.domain.Announcement;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface AnnouncementMapper {
//查截止时间
    @Select("select deadline from announcement where id=(select max(id) from announcement)")
    public Date findDeadline();

}
