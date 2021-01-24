package com.zhang.springboot.proxy.staticProxy;

public class StaticProxy implements RentHouse{
    private People people;
    public StaticProxy(People people){
        this.people = people;
    }

    @Override
    public void rent() {
        System.out.println("代理开始");
        people.rent();
        System.out.println("代理结束");
    }

    public static void main(String[] args) {
        People emon = new People();
        StaticProxy staticProxy = new StaticProxy(emon);
        staticProxy.rent();
    }
}
