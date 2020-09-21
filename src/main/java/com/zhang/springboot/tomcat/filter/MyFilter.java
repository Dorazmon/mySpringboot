package com.zhang.springboot.tomcat.filter;

import com.zhang.springboot.tomcat.wrapper.MyPrintWriter;
import com.zhang.springboot.tomcat.wrapper.WrapperRequest;
import com.zhang.springboot.tomcat.wrapper.WrapperResponse;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebFilter(filterName = "testfilter",urlPatterns ={"/blog/*"})
//@WebFilter(filterName = "testfilter",urlPatterns ={"/*"})
@WebFilter
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter");
        WrapperRequest wrapperRequest = new WrapperRequest(servletRequest);
        WrapperResponse wrapperResponse = new WrapperResponse((HttpServletResponse) servletResponse);
        filterChain.doFilter(wrapperRequest,wrapperResponse);
        MyPrintWriter printWriter = (MyPrintWriter) wrapperResponse.getWriter();
        //可以清空
        wrapperResponse.reset();
        printWriter.print("filter------haha");
    }

    @Override
    public void destroy() {

    }
}
