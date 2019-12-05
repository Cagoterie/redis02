package com.aaa.controller.user;

import com.aaa.service.user.UserInfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author qy105小仙女
 * @version 1.0
 * @Date 2019/10/30
 */

@Controller
@RequestMapping("/user")
public class UserInfoController {

    private static Logger logger = LoggerFactory.getLogger(UserInfoController.class);
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping(value = "/login")
    public String login(String userName,String userPassword, ModelMap modelMap)  {
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName, userPassword);
            try{
                subject.login(usernamePasswordToken);
                return "redirect:/book/bookInfo";
            } catch (UnknownAccountException uae){
                modelMap.addAttribute("msg",uae.getMessage());
            } catch (IncorrectCredentialsException ice){
                modelMap.addAttribute("msg","密码错误");
            } catch (LockedAccountException lae){
                modelMap.addAttribute("msg",lae.getMessage());
            } catch (AuthenticationException ae){
                modelMap.addAttribute("msg","认证失败");
            }
            return "login";
        }else {
            return "redirect:/book/bookInfo";
        }

    }


}
