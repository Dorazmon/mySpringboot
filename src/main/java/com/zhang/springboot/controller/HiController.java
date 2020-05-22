package com.zhang.springboot.controller;

import javax.servlet.http.HttpServletRequest;

import com.zhang.springboot.annotation.MyAnnotaion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HiController {

    @MyAnnotaion(name = "test", value = "7788")
    @RequestMapping("/hi")
    @ResponseBody
    public String sayHi() {
        System.out.println("有注解的controller");
        return "你好";
    }
}
