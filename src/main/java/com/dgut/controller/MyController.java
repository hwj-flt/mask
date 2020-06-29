package com.dgut.controller;

import com.alibaba.fastjson.JSONObject;
import com.dgut.common.Result;
import com.dgut.common.ResultStatus;
import com.dgut.domain.User;
import com.dgut.mapper.AnnouncementMapper;
import com.dgut.service.AnnouncementSevice;
import com.dgut.service.UserService;
import org.omg.PortableInterceptor.SUCCESSFUL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

@Controller
public class MyController {
    @Autowired
    private UserService userService;
    @Autowired
    private AnnouncementSevice announcementSevice;
//    写/login会导致登录页面无法显示，故用loginSubmit
    @RequestMapping(value = "/loginSubmit")
    @CrossOrigin
    public String login(@RequestBody Map<String,String> map, HttpSession session,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String username = map.get("username");
        String password = map.get("password");
        boolean key = userService.checkLogin(username,password);
        if(key){
            session.setAttribute("username",username);
            session.setAttribute("password",password);
            //登录成功，去往用户页面
            return "redirect:/user";
        }else {
            //登录失败，回到登录页面
            request.getRequestDispatcher("/login.html").forward(request,response);
            return null;
        }
    }
//      注销账号
    @RequestMapping(value = "/logout")
    @CrossOrigin
    public Result logout(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        session.invalidate();
        request.getRequestDispatcher("/login.html").forward(request,response);
        return null;
    }
//      用户页面
    @RequestMapping(value = "/user")
    @ResponseBody
    @CrossOrigin
    public Result user(HttpSession session,HttpServletRequest request){
        User user = userService.showUserByUsername((String) session.getAttribute("username"));
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(user);
        try {
            jsonObject.put("msg",request.getParameter("msg"));
        }finally {
            return new Result(ResultStatus.SUCCESS,jsonObject);
        }
    }
//      修改用户信息
    @RequestMapping(value = "/updateUser")
    @ResponseBody
    @CrossOrigin
    public ModelAndView updateUser(@RequestBody User user){
        user.setStatus(null);
        user.setRole(null);
        ModelMap model = new ModelMap();
        if(userService.updateUser(user))
            model.addAttribute("msg","修改成功");
        else
            model.addAttribute("msg","修改失败");
        //最后回到用户界面
        return new ModelAndView("redirect:/user",model, HttpStatus.OK);
    }
    //预约口罩页面判断是否预约过
    @RequestMapping(value = "/orderMask")
    @ResponseBody
    @CrossOrigin
    public ModelAndView orderMask(HttpSession session){
        Date deadline = announcementSevice.findDeadline();
        Date nowDate = new Date();
        ModelMap model = new ModelMap();
        if(nowDate.after(deadline)){
            model.addAttribute("msg","截止日期已过，不能预约了，请等下次口罩发布吧!");
            return new ModelAndView("redirect:/user",model, HttpStatus.OK);
        }
        User user = userService.showUserByUsername((String) session.getAttribute("username"));
        //预约过的用户回到用户界面，返回消息该用户已经预约过了
        if(user.getStatus()==1){
            model.addAttribute("msg","该用户已经预约过了");
            return new ModelAndView("redirect:/user",model, HttpStatus.OK);
        }
        return new ModelAndView("redirect:/order");
    }
    //执行预约操作，设置user.status为1，插入一条order数据
    @RequestMapping(value = "/order")
    @ResponseBody
    @CrossOrigin
    public ModelAndView order(HttpSession session){
        User user = userService.showUserByUsername((String) session.getAttribute("username"));
        ModelMap model = new ModelMap();
        if(userService.orderMask(user)){
            model.addAttribute("msg","预约成功");
        }
        else{
            model.addAttribute("msg","预约失败");
        }
        //回到用户界面
        return new ModelAndView("redirect:/user",model, HttpStatus.OK);
    }
}
