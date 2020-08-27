package com.zhang.springboot.reflect;

import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;

public class ClassTest {
    public void test(){
        System.out.println("test");
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
         ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//         Class clazz = classLoader.loadClass("com.zhang.springboot.reflect.ClassTest");
//         ClassTest classTest = (ClassTest) clazz.newInstance();
//         classTest.test();
        Enumeration<URL> urls = classLoader.getResources("META-INF/spring.properties");
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            UrlResource resource = new UrlResource(url);
            Properties properties = PropertiesLoaderUtils.loadProperties(resource);
            String name = properties.getProperty("name");
            System.out.println(name);
        }
        InputStream fis = classLoader.getResourceAsStream("META-INF"+ File.separator+"spring.properties");
        Properties prop = new Properties();
        prop.load(fis);
        String name = prop.getProperty("name");
        System.out.println(name);
    }
}
