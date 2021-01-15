package com.zhang.springboot.thread.lock.opLock;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSourceOpt {

    private AtomicInteger atomicInteger;

    public ThreadSourceOpt(int i){
        atomicInteger = new AtomicInteger(i);
    }

    public int add(){
        int temAtomicIntegerI = atomicInteger.get();
        int temAtomicIntegerValue = temAtomicIntegerI + 1;
        //如果和之前一样的数据则说明别的线程还没操作
        if(!atomicInteger.compareAndSet(temAtomicIntegerI,temAtomicIntegerValue)){
            add();
        }
        return atomicInteger.get();
    }

    public int getI(){
        return this.atomicInteger.get();
    }
}
