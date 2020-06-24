package com.dgut.controller;

import com.dgut.domain.User;
import com.dgut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String loginPage(){
        return "register";
    }
    @RequestMapping("/register")
    public String register(@RequestParam(value = "username",required = false) String username, @RequestParam(value = "id",required = false) String id, @RequestParam(value = "name",required = false)String name, @RequestParam(value = "sex",required = false)String sex, @RequestParam(value = "password",required = false)String password, @RequestParam(value = "address",required = false)String address,@RequestParam(value = "phone",required = false)String phone){
        User u = new User();
        u.setUsername(username);
        u.setId(id);
        u.setName(name);
        u.setSex(sex);
        u.setAddress(address);
        u.setPassword(password);
        u.setPhone(phone);
        if (userService.find(username,id)==null){
        userService.register(u);}
        else{
            System.out.println("重复");
        }
        return "success";
    }

}
