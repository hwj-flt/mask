package com.dgut.controller;

import com.dgut.domain.Announcement;
import com.dgut.service.AnnouncementService;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Controller
public class AnnouncementController {
    @Autowired
    private AnnouncementService announcementService;
    @RequestMapping("toinsert")
    public String toinsert(){
        return "insert";
    }

    @RequestMapping("/insert")
    public String insert(@RequestParam(value = "num",required = false)Integer num,@RequestParam(value = "content",required = false)String content){
        Announcement a =new Announcement();
        Calendar calendar = Calendar.getInstance();
        Date time=calendar.getTime();
        a.setContent(content);
        a.setNum(num);
        a.setTime(time);
        announcementService.insert(a);
        return "announcement";
    }
    @RequestMapping("/show")
    public String show(){
        Announcement a =new Announcement();
        a=announcementService.show();
        System.out.println(a);
        return "announcement";
    }
    @RequestMapping("showall")
    public String showall(){
        List<Announcement> a= announcementService.showall();
        System.out.println(a);
        return "announcement";
    }
}
