package com.zhang.springboot.thread.csmodel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class ReadFile {
  private final int size = 20;
  //线程池
  private ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
  //缓冲队列
  private List<Queue<String>> list = new ArrayList<Queue<String>>();
  public ReadFile(){
    Queue queueOne = new LinkedBlockingQueue();
    Queue queueTwo = new LinkedBlockingQueue();
    list.add(queueOne);
    list.add(queueTwo);
  }
  public void ReadFile(String fileOnePath,String fileTwoPath){
    readFileSingle(fileOnePath,list.get(0));
    readFileSingle(fileOnePath,list.get(1));
  }

  /**
   * 校验
   * @param queueOne
   * @throws InterruptedException
   */
  public void checkQueueSize(Queue queueOne) throws InterruptedException {
    while(queueOne.size()>size){
       Thread.currentThread().sleep(10000);
    }
  }

  public void readFileSingle(String path,Queue<String> queue){
    cachedThreadPool.submit(new Runnable() {
      @Override
      public void run() {
        try {
          byte[] bytes = new byte[1024];
          FileInputStream fileis = new FileInputStream(new File(path));
          while(fileis.read(bytes)>0){
            checkQueueSize(queue);
            queue.add(new String(bytes));
          }
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        } catch (IOException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

      }
    });
  }

  public List<String> compare(String path){
      Queue<String> queueOne = list.get(0);
      Queue<String> queueTwo = list.get(1);
      List<String> list = new ArrayList<>();
      while(true&!Thread.currentThread().isInterrupted()){
        String str = queueOne.poll();
        if(str.equals(queueTwo.poll())){
          list.add(str);
        }
      }
      return list;
    }

  }


