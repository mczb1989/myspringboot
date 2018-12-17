package com.zb.controller;

import com.github.pagehelper.PageInfo;
import com.zb.model.User;
import com.zb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhangbin on 2018/8/9.
 */
@Controller
public class BookController {
    @Autowired
    private BookService userService;

    @RequestMapping("/booklist")
    public String getUserList(Model model, PageInfo pageInfo){
        int pageNum  = (pageInfo.getPageNum() == 0)? 1 : pageInfo.getPageNum();
        int pageSize  = (pageInfo.getPageSize() == 0)? 10 : pageInfo.getPageSize();
        PageInfo<User> result = userService.selectAll(pageNum, pageSize);
        model.addAttribute("booklist", result.getList());
        model.addAttribute("pageInfo", result);
        return "booklist";
    }
}
