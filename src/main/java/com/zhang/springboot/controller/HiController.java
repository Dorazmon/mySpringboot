package com.zhang.springboot.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HiController {
  @RequestMapping("/hi")
  @ResponseBody
  public String sayHi(){
     return "你好";
  }
}
