package com.dgut.controller;

import com.dgut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;
import java.io.IOException;

@Controller
public class MyController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/loginSubmit")
    public String login(String username, String password, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean key = userService.checkLogin(username,password);
        if(key){
            session.setAttribute("username",username);
            session.setAttribute("password",password);
            return "index";
        }else {
            request.getRequestDispatcher("/login.html").forward(request,response);
            return null;
        }
    }
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:login.html";
    }
}
