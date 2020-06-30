package com.dgut.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dgut.domain.*;
import com.dgut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String loginPage() {
        return "register";
    }

    @RequestMapping("/register")
    @ResponseBody
    @CrossOrigin
    public Result register(@RequestBody User u) {
        String username = u.getUsername();
        u.setUsername(u.getUsername());
        String id = u.getId();
        u.setId(u.getId());
        u.setName(u.getName());
        u.setSex(u.getSex());
        u.setAddress(u.getAddress());
        u.setPassword(u.getPassword());
        u.setPhone(u.getPhone());
        u.setBirthday(u.getBirthday());
//        String birthday = request.getParameter("birthday");
//        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
//        Date date;
//        try{
//         date = f.parse(birthday);
//            u.setBirthday(date);
//        }catch (ParseException e){
//            e.printStackTrace();
//        }
        if (userService.find(username, id) == null) {
            userService.register(u);
            return new Result(ResultStatus.SUCCESS);
        } else {
            return new Result(ResultStatus.SERVICE_EXCEPTION);
        }
    }

    @RequestMapping("/findAll")
    @ResponseBody
    @CrossOrigin
    public Result findAll() {
        //1获取所有用户名
        List<User> users = userService.findAll();
        JSONArray jsonArray = (JSONArray) JSONArray.toJSON(users);
        return new Result(ResultStatus.SUCCESS, jsonArray);
        //2选择要修改的用户

        //3修改用户信息
    }

    @RequestMapping("/user")
    @ResponseBody
    @CrossOrigin
    public Result user(HttpSession session) {
        //点击用户名,进入用户个人主页
        User user = userService.findUserByUsername((String) session.getAttribute("username"));
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(user);
        return new Result(ResultStatus.SUCCESS, jsonObject);
    }

    @RequestMapping("/RoleupdateUser")
    @ResponseBody
    @CrossOrigin
    //修改用户信息
    public Result RoleupdateUser(@RequestBody User user) {
        user.setPassword(user.getPassword());
        user.setUsername(user.getUsername());
        user.setSex(user.getSex());
        user.setAddress(user.getAddress());
        user.setStatus(user.getStatus());
        user.setBirthday(user.getBirthday());
        user.setId(user.getId());
        user.setName(user.getName());
        user.setPhone(user.getPhone());
        user.setRole(user.getRole());
        if (userService.RoleupdateUserByUsername(user))
            return new Result(ResultStatus.SUCCESS);
        else
            return new Result(ResultStatus.SERVICE_EXCEPTION);
    }


    //选取成功预约口罩的用户
    @RequestMapping("maskChoose")
    @ResponseBody
    @CrossOrigin
    public Result maskChoose() {
        //获取公告栏口罩数量
        int num = userService.selectnum();
        //选取成功预约口罩的用户,封装到List集合
        List<User> user = userService.choose(num);
        //转换为JSON格式输出到前端
        JSONArray jsonArray = (JSONArray) JSONArray.toJSON(user);
        //清空order表
        userService.deleteOrder();
        //将所有user的statu为1的改为0
        userService.updateStatu();
        return new Result(ResultStatus.SUCCESS, jsonArray);
    }
}
