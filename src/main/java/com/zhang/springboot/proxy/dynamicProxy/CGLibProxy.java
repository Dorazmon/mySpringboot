package com.zhang.springboot.proxy.dynamicProxy;

import com.zhang.springboot.proxy.staticProxy.People;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 原理是继承,被代理的对象不能被final修饰
 */
public class CGLibProxy implements MethodInterceptor {

    private Object object;

    private void setObject(Object object){
        this.object = object;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("动态代理前");
        method.invoke(object,objects);
        System.out.println("动态代理后");
        return null;
    }

    public static void main(String[] args) {
        People people = new People();
        //创建Enhancer对象，类似于JDK动态代理的Proxy类，下一步就是设置几个参数
        Enhancer enhancer = new Enhancer();
        //设置目标类的字节码文件
        enhancer.setSuperclass(People.class);
        //设置回调函数
        CGLibProxy cgLibProxy = new CGLibProxy();
        cgLibProxy.setObject(people);
        enhancer.setCallback(cgLibProxy);

        //这里的creat方法就是正式创建代理类
        People proxyDog = (People) enhancer.create();
        //调用代理类的eat方法
        proxyDog.rent();

    }
}
