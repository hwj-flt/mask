package com.dgut.interceptor;

<<<<<<< HEAD
public class LoginInterceptor {
=======
import com.dgut.domain.User;
import com.dgut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private UserService userService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getRequestURI().equals("/") ){
            return true;
        }
        if (request.getRequestURI().indexOf("login") >= 0){
            return true;
        }
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");
        if (username!=null && password!=null){
            if (userService.checkLogin(username,password)){
                return true;
            }
        }
        request.getRequestDispatcher("/login.html").forward(request,response);
        return false;
    }
>>>>>>> master
}
