package com.zb.controller;

import com.github.pagehelper.PageInfo;
import com.zb.model.User;
import com.zb.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhangbin on 2018/8/6.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    @ResponseBody
    public User getUserById(int id){
        User user = userService.selectByPrimaryKey(id);
        return user;
    }

    @RequestMapping("/userlist")
    @RequiresPermissions("user:list")
    public String getUserList(Model model, PageInfo pageInfo){
        int pageNum  = (pageInfo.getPageNum() == 0)? 1 : pageInfo.getPageNum();
        int pageSize  = (pageInfo.getPageSize() == 0)? 10 : pageInfo.getPageSize();
        PageInfo<User> result = userService.selectAll(pageNum, pageSize);
        model.addAttribute("users", result.getList());
        model.addAttribute("pageInfo", result);
        return "userlist";
    }

    @RequestMapping("/userdelete")
    @RequiresPermissions("user:delete")
    public String userdelete(int id){
        userService.deleteByPrimaryKey(id);
        return "redirect:/userlist";
    }

    @RequestMapping("/useredit")
    @RequiresPermissions("user:edit")
    public String useredit(int id, Model model){
        User user = userService.selectByPrimaryKey(id);
        model.addAttribute("user", user);
        return "useredit";
    }

    @RequestMapping(value = "/userupdateoradd", method = RequestMethod.POST)
    @RequiresPermissions("user:updateoradd")
    public String userUpdateOrAdd(User user){
        if(user.getId() == 0){
            userService.insertSelective(user);
        } else {
            userService.updateByPrimaryKeySelective(user);
        }
        return "redirect:/userlist";
    }

}
