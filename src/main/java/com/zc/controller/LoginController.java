package com.zc.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author 周超
 * @Date 2020/4/9 17:58
 * @Version 1.0
 **/
@Controller
//@RequestMapping("")
public class LoginController {
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(Model model,String name,String password){
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(name,password);
        try {
            subject.login(token);
            Session session = subject.getSession();
            session.setAttribute("subject",subject);
            return "redirect:index";
        } catch (AuthenticationException e) {
            model.addAttribute("error","验证失败");
            return "login";
        }
    }
}
