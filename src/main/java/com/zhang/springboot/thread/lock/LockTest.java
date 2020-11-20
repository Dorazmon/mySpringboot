package com.zhang.springboot.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    public void test() throws InterruptedException {
        lock.lock();
        condition.await();
        System.out.println("fff");

    }

    public static void main(String[] args) throws InterruptedException {
        LockTest lockTest = new LockTest();
        lockTest.test();
    }
}
