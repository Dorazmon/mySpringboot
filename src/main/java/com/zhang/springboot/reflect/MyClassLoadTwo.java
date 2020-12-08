package com.zhang.springboot.reflect;

public class MyClassLoadTwo extends ClassLoader{
    public boolean havaLoad(String className){
        Class<?> c = findLoadedClass(className);
        if(c==null){
            return false;
        }else{
            return true;
        }
    }
}
