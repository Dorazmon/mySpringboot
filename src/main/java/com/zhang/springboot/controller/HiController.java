package com.zhang.springboot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhang.springboot.annotation.MyAnnotaion;
import com.zhang.springboot.utils.HttpClientPostFs;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@Controller
public class HiController {

    @RequestMapping("/hi")
    @ResponseBody
    public String sayHi() {
        System.out.println("有注解的controller");
        return "你好v1";
    }

     @RequestMapping("/testRedirect")
    public void  testRedirect(HttpServletResponse resp, RedirectAttributes attributes) throws IOException {
        //resp.setHeader("test","zzzzzzzzzzzzzzzzzz");
//        resp.setStatus(302);
//        //attributes.addFlashAttribute("test", "zzzzzzzzzzzzzzzzzz");
//        //resp.sendRedirect("http://localhost:8080/testRecvData");
//         resp.setHeader("Location","http://localhost:8080/testRecvData");
//         resp.setHeader("test","zzzzzzzzzzz");
//         RedirectWithPost redirectWithPost = new RedirectWithPost(response);
//         String redirectUrl = request.getContextPath() + "/eventweb/declare.sp";
//         redirectWithPost.setParameter("loginId", loginId);
//         redirectWithPost.sendByPost(redirectUrl);
         HttpClientPostFs http=new HttpClientPostFs(resp);
         http.setParameter("test","zzzzzzzzzzzzzzzzzzzzzz");//将参数封装到这个里面,以键值对的形式存在
         http.sendByPost("http://localhost:8080/testRecvData");//重定向的地址
    }

    @RequestMapping("/testRecvData")
    public void testRecvData(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse){
        Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
        System.out.println(httpServletRequest.getParameter("test"));
        System.out.println("接收");
    }

    @RequestMapping("/testFilter")
    //@ResponseBody
    public void testFilter(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws IOException {
       httpServletRequest.getParameter("zhang");
       PrintWriter printWriter = httpServletResponse.getWriter();
       printWriter.print("controller-----hehe");
    }
}
