package com.zhang.springboot.tomcat.wrapper;


import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.HashMap;
import java.util.Map;

public class WrapperRequest extends HttpServletRequestWrapper {
    private Map<String, String[]> parameterMap; // 所有参数的Map集合
    public WrapperRequest(ServletRequest request) {
        super((HttpServletRequest) request);
        Map<String, String[]> oldParameterMap = request.getParameterMap();
        parameterMap = new HashMap<String, String[]>();
        String[] str = new String[1];
        str[0] = "gan";
        parameterMap.put("zhang",str);
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        return parameterMap;
    }

    @Override
    public String getParameter(String name) {
        String str = parameterMap.get(name)[0];
        return str;
    }
}
