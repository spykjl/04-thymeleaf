package com.karl.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @RequestMapping("/user/login")
//    @ResponseBody
    public String login(@RequestParam String username, @RequestParam String password, Model model,
                        HttpSession session){
        Subject subject= SecurityUtils.getSubject();
        //封装用户登录数据
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        System.out.println(token);
        //登录
        try {
            subject.login(token);
            return "redirect:/main.html";
        }catch (UnknownAccountException e){
            model.addAttribute("msg","用户名不存在");
            return "index";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return "index";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/index";
    }

    @RequestMapping("/noAuth")
    @ResponseBody
    public String noAuth(){
        return "您没有相关权限";
    }
}
