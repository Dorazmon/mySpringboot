package com.zhang.springboot.thread.lock.opLock;

public class OptimisticTest {
    public static void main(String[] args) throws InterruptedException {
        //公共资源
        ThreadSourceOpt threadSourceOptNoABA = new ThreadSourceOpt(0);
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 5000000; i++) {
                    System.out.println(threadSourceOptNoABA.add());
                }
                System.out.println("thread one");
            }
        };

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 5000000; i++) {
                    System.out.println(threadSourceOptNoABA.add());
                }
                System.out.println("thread two");
            }
        };
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(threadSourceOptNoABA.getI());
    }
}
