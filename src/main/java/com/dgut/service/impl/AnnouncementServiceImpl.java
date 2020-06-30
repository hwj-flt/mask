package com.dgut.service.impl;

import com.dgut.domain.Announcement;
import com.dgut.mapper.AnnouncementMapper;
import com.dgut.service.AnnouncementService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("AnnouncementService")
public class AnnouncementServiceImpl implements AnnouncementService {
    @Autowired
    private AnnouncementMapper announcementMapper;

    public Announcement show(){
        return announcementMapper.show();
    }
    public List<Announcement> showall(){
        return announcementMapper.showall();
    }
    public void insert(Announcement announcement){
        announcementMapper.insert(announcement);
    }

    @Override
    public Announcement findById(@Param("id") int id) {
        return announcementMapper.findById(id);
    }

}
