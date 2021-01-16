package com.zhang.springboot.io.fileLock;

import java.io.FileWriter;
import java.io.IOException;

public class MultipleFile {
    public static void main(String[] args) {
        Thread thread1 = new Thread(){
            public void run(){
                try {
                    FileWriter writer = new FileWriter("D:\\test.txt",true);
                    writer.write("VVVVVVVV");
                    writer.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException("写入失败");
                }
            };
        };
        thread1.start();

        Thread thread2 = new Thread(){
            public void run(){
                try {
                    FileWriter writer = new FileWriter("D:\\test.txt",true);
                    writer.write("cccccc");
                    writer.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException("写入失败");
                }
            };
        };
        thread2.start();

        Thread thread3 = new Thread(){
            public void run(){
                try {
                    FileWriter writer = new FileWriter("D:\\test.txt",true);
                    writer.write("aaa");
                    writer.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException("写入失败");
                }
            };
        };
        thread3.start();
    }
}
