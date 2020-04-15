package com.zhang.springboot.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.TYPE, ElementType.METHOD})//使用位置（类，方法）
@Retention(RetentionPolicy.RUNTIME)//加载到jvm里运行
public @interface MyAnnotaion {
    String value(); //注解的属性，如果只有一个属性，一般叫value
    String name() default ""; //属性，默认值""，可以不写
}
