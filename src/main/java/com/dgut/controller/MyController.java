package com.dgut.controller;

import com.dgut.domain.User;
import com.dgut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    public String login(String username, String password, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean key = userService.checkLogin(username,password);
        if(key){
            session.setAttribute("username",username);
            session.setAttribute("password",password);
            return "redirect:/user";
        }else {
            request.getRequestDispatcher("/login.html").forward(request,response);
            return null;
        }
    }
//      注销账号
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:login.html";
    }
//      用户页面
    @RequestMapping(value = "/user")
    @ResponseBody
    public ModelAndView user(HttpSession session){
        User user = userService.showUserByUsername((String) session.getAttribute("username"));
        ModelMap model = new ModelMap();
        //将查到的数据通过ModelAndView传回
        model.addAttribute("username",user.getUsername());
        model.addAttribute("name",user.getName());
        model.addAttribute("sex",user.getSex());
        model.addAttribute("password",user.getPassword());
        model.addAttribute("id",user.getId());
        model.addAttribute("birthday",user.getBirthday());
        model.addAttribute("address",user.getAddress());
        model.addAttribute("phone",user.getPhone());
        model.addAttribute("role",user.getRole());
        model.addAttribute("status",user.getStatus());
        return new ModelAndView("user",model);
    }
//      修改用户信息
    @RequestMapping(value = "/updateUser")
    @ResponseBody
    public ModelAndView updateUser(HttpServletRequest request,HttpServletResponse response){
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
        userService.updateUser(user);
        //修改完后回到用户界面
        return new ModelAndView("redirect:user");
    }
    /*public String updateUser(@RequestBody User user){
        userService.updateUser(user);
        return "user";
    }*/
    /*public String updateUser(@RequestBody Map<String,String> map){
        User user = new User();
        user.setUsername(map.get("username"));
        user.setPassword(map.get("password"));
        user.setSex(map.get("sex"));
        user.setRole(map.get("role"));
        user.setAddress(map.get("address"));
        user.setStatus(Integer.valueOf(map.get("status")));
        user.setBirthday(Date.valueOf(map.get("birthday")));
        user.setId(map.get("id"));
        user.setName(map.get("name"));
        user.setPhone(map.get("phone"));
        userService.updateUser(user);
        return "user";
    }*/
}
