package com.zhang.springboot.reflect;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PathTest {
    public static void main(String[] args) throws Exception {
//        new PathTest().getClass().getProtectionDomain().getCodeSource().getLocation();
        System.out.println(readPort("JG_TIMER"));
    }
    /**
     * 从jar外部获取配置信息
     * @param name
     *            需要获取的属性名
     * @return
     */
    public static String readPort(String name) {
        //
        String property = System.getProperty("user.dir");
        try {
            Properties prop = new Properties();
            InputStream in = new BufferedInputStream(new FileInputStream(property+"port.properties"));
            prop.load(in);
            String value = prop.getProperty(name);
            if (null==value || value.equals("")) {
                System.out.println("配置文件中不存在该属性");
            }
            return value;
        } catch (Exception e) {
            System.out.println("获取配置文件出错,请检查路径");
            e.printStackTrace();
        }
        return null;
    }
}
