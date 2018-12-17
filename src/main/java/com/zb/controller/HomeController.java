package com.zb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangbin on 2018/8/6.
 */
@RestController
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "Hello World!";
    }
}
