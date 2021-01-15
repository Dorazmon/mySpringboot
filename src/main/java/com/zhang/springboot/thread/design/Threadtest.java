package com.zhang.springboot.thread.design;

public class Threadtest extends Thread{

    private String threadName;

    public void Threadtest(String threadName){
        this.threadName = threadName;
    }

    @Override
    public void run() {

        System.out.println("v1");
        System.out.println("v2");
        System.out.println("v3");

        getV("v1");
        getV("v2");
        getV("v3");

    }

    public void getV(String temp){
        System.out.println(temp);
    }

    public void getV1() {
        System.out.println("v1");
    }

    public void getV2(){
        System.out.println("v2");
    }


}
