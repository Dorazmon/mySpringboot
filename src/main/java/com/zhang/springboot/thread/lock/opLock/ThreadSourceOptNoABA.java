package com.zhang.springboot.thread.lock.opLock;


import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSourceOptNoABA {
    //解决ABA问题的版本号
    private AtomicInteger atomicIntegerVersion = new AtomicInteger(0);
    //变量i
    private AtomicInteger atomicIntegerI ;

    public ThreadSourceOptNoABA(int i){
        atomicIntegerI = new AtomicInteger(i);
    }

    public int add(){
        int tempVersion = atomicIntegerVersion.get();
        if(atomicIntegerVersion.compareAndSet(tempVersion,tempVersion+1)){
            addI();
        }else{
            add();
        }
        return atomicIntegerI.get();
    }

    public void addI(){
        int tempI = atomicIntegerI.get();
        if(!atomicIntegerI.compareAndSet(tempI,tempI+1)){
            addI();
        }
    }

    public int getI(){
        return atomicIntegerI.get();
    }
}
