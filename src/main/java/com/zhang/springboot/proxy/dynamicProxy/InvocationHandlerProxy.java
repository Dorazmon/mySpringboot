package com.zhang.springboot.proxy.dynamicProxy;

import com.zhang.springboot.proxy.staticProxy.People;
import com.zhang.springboot.proxy.staticProxy.RentHouse;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 局限性，被代理类需要实现接口
 */
public class InvocationHandlerProxy implements InvocationHandler {

    private Object object;

    public void setTarObject(Object object){
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始代理");
        //执行目标方法
        method.invoke(object,args);
        System.out.println("代理结束");
        return null;
    }

    public static void main(String[] args) {
        InvocationHandlerProxy invocationHandlerProxy = new InvocationHandlerProxy();
        People people = new People();
        invocationHandlerProxy.setTarObject(people);
        //Class[] classes = new Class[]{RentHouse.class};
        RentHouse peopleProxy = (RentHouse) Proxy.newProxyInstance(people.getClass().getClassLoader(), people.getClass().getInterfaces(), invocationHandlerProxy);
        peopleProxy.rent();
    }
}
