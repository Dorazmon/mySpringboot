package com.zhang.springboot.tomcat.wrapper;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.*;

public class WrapperResponse extends HttpServletResponseWrapper {
    private MyPrintWriter pwrite;

    private StringBuilder stringBuilder;

    public WrapperResponse(HttpServletResponse response) throws IOException {
        super(response);
        this.pwrite = new MyPrintWriter(super.getWriter());
    }

    /**
     * 重写父类的 getWriter() 方法，将响应数据缓存在 PrintWriter 中
     */
    @Override
    public PrintWriter getWriter() throws IOException {
        return pwrite;
    }
}
