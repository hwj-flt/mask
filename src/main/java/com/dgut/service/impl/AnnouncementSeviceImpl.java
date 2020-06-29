package com.dgut.service.impl;

import com.dgut.mapper.AnnouncementMapper;
import com.dgut.service.AnnouncementSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class AnnouncementSeviceImpl implements AnnouncementSevice {
    @Autowired
    private AnnouncementMapper announcementMapper;
    @Override
    public Date findDeadline() {
        return announcementMapper.findDeadline();
    }
}
