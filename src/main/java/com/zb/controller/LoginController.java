package com.zb.controller;

import com.zb.model.User;
import com.zb.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by zhangbin on 2018/8/9.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/login_in", method = RequestMethod.POST)
    public String login_in(User user, HttpServletRequest request, Model model){
        User user1 = userService.validateUser(user.getUsername(), user.getPassword());
        if(user1 == null){
            return "login";
        }

        // (1) session
//        HttpSession session = request.getSession();
//        session.setAttribute(session.getId(), user1);
//        return "redirect:/userlist";

        // (2) jwt
        //String token = JwtToken.createToken(user1.getId(), user1.getUsername());

        // (3) shiro
        String msg ;
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        token.setRememberMe(true);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            if (subject.isAuthenticated()) {
                //shiro 的session和request的session封装的是一个，就是说两个都可以
//                request.getSession().setAttribute(request.getSession().getId(),user);
                subject.getSession().setAttribute(subject.getSession().getId(),user);
                return "redirect:/userlist";
            } else {
                return "login";
            }
        } catch (IncorrectCredentialsException e) {
            msg = "登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.";
            model.addAttribute("message", msg);
            System.out.println(msg);
        } catch (ExcessiveAttemptsException e) {
            msg = "登录失败次数过多";
            model.addAttribute("message", msg);
            System.out.println(msg);
        } catch (LockedAccountException e) {
            msg = "帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.";
            model.addAttribute("message", msg);
            System.out.println(msg);
        } catch (DisabledAccountException e) {
            msg = "帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.";
            model.addAttribute("message", msg);
            System.out.println(msg);
        } catch (ExpiredCredentialsException e) {
            msg = "帐号已过期. the account for username " + token.getPrincipal() + "  was expired.";
            model.addAttribute("message", msg);
            System.out.println(msg);
        } catch (UnknownAccountException e) {
            msg = "帐号不存在. There is no user with username of " + token.getPrincipal();
            model.addAttribute("message", msg);
            System.out.println(msg);
        } catch (UnauthorizedException e) {
            msg = "您没有得到相应的授权！" + e.getMessage();
            model.addAttribute("message", msg);
            System.out.println(msg);
        }
        return "login";

    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
//        request.getSession().removeAttribute(request.getSession().getId());
        SecurityUtils.getSubject().getSession().removeAttribute(SecurityUtils.getSubject().getSession().getId());
        return "login";
    }
}
