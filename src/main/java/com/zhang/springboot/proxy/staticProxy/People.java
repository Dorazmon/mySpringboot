package com.zhang.springboot.proxy.staticProxy;

public  class People implements RentHouse{

    @Override
    public void rent() {
        System.out.println("租房");
    }
}
