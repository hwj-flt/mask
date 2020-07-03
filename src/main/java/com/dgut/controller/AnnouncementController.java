package com.dgut.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dgut.domain.Announcement;
import com.dgut.common.Result;
import com.dgut.common.ResultStatus;
import com.dgut.service.AnnouncementService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/announcement")
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
    @RequestMapping("/showall")
    @ResponseBody
    @CrossOrigin
    public Result showall(){
        List<Announcement> a= announcementService.showall();
        JSONArray jsonArray = (JSONArray) JSONArray.toJSON(a);
        return new Result(ResultStatus.SUCCESS,jsonArray);
    }
    @RequestMapping("/find")
    @ResponseBody
    @CrossOrigin
    public Result findById(@Param("id")int id){
        Announcement a = announcementService.findById(id);
        JSONObject jsonObject= (JSONObject) JSONObject.toJSON(a);
        return new Result(ResultStatus.SUCCESS,jsonObject);
    }
}
