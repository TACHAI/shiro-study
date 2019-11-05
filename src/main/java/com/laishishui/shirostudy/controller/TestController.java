package com.laishishui.shirostudy.controller;

import com.laishishui.shirostudy.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Create by tachai on 2019-11-05 15:28
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
@Controller
public class TestController {

    @GetMapping("/index")
    public String login(){
        return "login";
    }

    @RequestMapping("/loginUser")
    public String loginUser(HttpSession session, @RequestParam("username")String username, @RequestParam("password")String password){
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(token);
            User user = (User)subject.getPrincipal();
            session.setAttribute("user",user);
            return "index";
        }catch (Exception e){
            return "login";
        }
    }
}
