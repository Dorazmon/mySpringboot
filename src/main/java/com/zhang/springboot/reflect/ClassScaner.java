package com.zhang.springboot.reflect;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ClassScaner {

  public static void main(String[] args) throws IOException {
    List<URL> urlLists = new ArrayList<URL>();
    Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(ClassScaner.class.getPackage().getName());
    while(urls.hasMoreElements()){
      urlLists.add(urls.nextElement());
    }
    URL url = urlLists.get(0);
    String path = url.getPath();
    System.out.println(path);
    System.out.println(ClassScaner.class.getPackage().getName());
  }
}
