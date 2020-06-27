package com.dgut.controller;

import com.alibaba.fastjson.JSONObject;
import com.dgut.common.Result;
import com.dgut.common.ResultStatus;
import com.dgut.domain.User;
import com.dgut.service.UserService;
import org.omg.PortableInterceptor.SUCCESSFUL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.Map;

@Controller
public class MyController {
    @Autowired
    private UserService userService;
//    写/login会导致登录页面无法显示，故用loginSubmit
    @RequestMapping(value = "/loginSubmit")
    @ResponseBody
    @CrossOrigin
    public Result login(String username, String password, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean key = userService.checkLogin(username,password);
        if(key){
            session.setAttribute("username",username);
            session.setAttribute("password",password);
            return new Result(ResultStatus.SUCCESS);
        }else {
//            request.getRequestDispatcher("/login.html").forward(request,response);
            return new Result(ResultStatus.ERROR);
        }
    }
//      注销账号
    @RequestMapping(value = "/logout")
    @ResponseBody
    @CrossOrigin
    public Result logout(HttpSession session){
        session.invalidate();
        return new Result(ResultStatus.SUCCESS);
    }
//      用户页面
    @RequestMapping(value = "/user")
    @ResponseBody
    @CrossOrigin
    public Result user(HttpSession session){
        User user = userService.showUserByUsername((String) session.getAttribute("username"));
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(user);
        return new Result(ResultStatus.SUCCESS,jsonObject);
    }
//      修改用户信息
    @RequestMapping(value = "/updateUser")
    @ResponseBody
    @CrossOrigin
    public Result updateUser(HttpServletRequest request,HttpServletResponse response){
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setSex(request.getParameter("sex"));
        user.setAddress(request.getParameter("address"));
        user.setStatus(Integer.valueOf(request.getParameter("status")));
        user.setBirthday(Date.valueOf(request.getParameter("birthday")));
        user.setId(request.getParameter("id"));
        user.setName(request.getParameter("name"));
        user.setPhone(request.getParameter("phone"));
        if(userService.updateUser(user))
            return new Result(ResultStatus.SUCCESS);
        else
            return new Result(ResultStatus.SERVICE_EXCEPTION);
    }
    //预约口罩页面判断是否预约过
    @RequestMapping(value = "/orderMask")
    @ResponseBody
    @CrossOrigin
    public Result orderMask(HttpServletRequest request){
        User user = userService.showUserByUsername((String) request.getParameter("username"));
        if(user.getStatus()==1){
            ModelMap model = new ModelMap();
            model.addAttribute("msg","该用户已经预约过了");
            return new Result(ResultStatus.ERROR,model);
        }
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(user);
        return new Result(ResultStatus.SUCCESS,jsonObject);
    }
    //执行预约操作，设置user.status为1，插入一条order数据
    @RequestMapping(value = "/order")
    @ResponseBody
    @CrossOrigin
    public Result order(HttpSession session){
        User user = userService.showUserByUsername((String) session.getAttribute("username"));
        if(userService.orderMask(user))
            return new Result(ResultStatus.SUCCESS);
        else
            return new Result(ResultStatus.SERVICE_EXCEPTION);
    }
}
