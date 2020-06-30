package com.dgut.service;

import com.dgut.domain.Announcement;

import java.util.Date;
import java.util.List;

public interface AnnouncementService {
    public Announcement show();
    public List<Announcement> showall();
    public void insert(Announcement announcement);
    //获取截止时间
    Date findDeadline();
}
