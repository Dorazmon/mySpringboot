package com.zhang.springboot.io.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class BioServer {
    public void serve(int port) throws IOException {
        // 开启Socket服务器，并监听端口
        final ServerSocket socket = new ServerSocket(port);
        try{
            for(;;){
                // 轮训接收监听,native方法阻塞DualStackPlainSocketImpl的accept0方法
                final Socket clientSocket = socket.accept();
//                try {
//                    Thread.sleep(500000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println("accepted connection from "+clientSocket);
                // 创建新线程处理请求

                new Thread(()->{
                    OutputStream out;
                    try{
                        out = clientSocket.getOutputStream();
                        String str = "HTTP/1.1 200 OK \r\n" +
                                                 "Content-type:text/html\r\n" +
                                                "\r\n"+"<!DOCTYPE html>\n" +
                                "<html>\n" +
                                "<head>\n" +
                                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                                "</head>\n" +
                                "<body>hi! 章\n" +
                                "</body>\n" +
                                "</html>";
                        out.write(str.getBytes("utf-8"));
                        out.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try{
                            clientSocket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
        BioServer server = new BioServer();
        System.out.println("Bio服务器启动");
        server.serve(5555);
    }
}
