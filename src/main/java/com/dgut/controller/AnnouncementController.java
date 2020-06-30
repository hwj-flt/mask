package com.dgut.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dgut.domain.Announcement;
import com.dgut.domain.Result;
import com.dgut.domain.ResultStatus;
import com.dgut.service.AnnouncementService;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.Gson;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@Controller
public class AnnouncementController {
    @Autowired
    private AnnouncementService announcementService;
    @RequestMapping("toinsert")
    public String toinsert(){
        return "insert";
    }

    @RequestMapping("/insert")
    @ResponseBody
    @CrossOrigin
    public Result insert(@RequestBody Announcement a){
        Calendar calendar = Calendar.getInstance();
        Date time=calendar.getTime();
        a.setContent(a.getContent());
        a.setNum(a.getNum());
        a.setTime(time);
        a.setDeadline(a.getDeadline());
        announcementService.insert(a);
        return new Result(ResultStatus.SUCCESS);
    }

    @PostMapping("/show")
    @ResponseBody
    @CrossOrigin
    public Result show(HttpSession session){
        Announcement a =new Announcement();
        a=announcementService.show();
        JSONObject jsonObject= (JSONObject) JSONObject.toJSON(a);
        return new Result(ResultStatus.SUCCESS,jsonObject);
    }
    @RequestMapping("showall")
    @ResponseBody
    @CrossOrigin
    public Result showall(){
        List<Announcement> a= announcementService.showall();
        JSONArray jsonArray = (JSONArray) JSONArray.toJSON(a);
        return new Result(ResultStatus.SUCCESS,jsonArray);
    }
}
