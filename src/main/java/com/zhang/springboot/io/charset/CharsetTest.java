package com.zhang.springboot.io.charset;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class CharsetTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(new String("章".getBytes(),"GBK"));
        System.out.println("章".getBytes());
        System.out.println(new String("章".getBytes("GBK"),"GBK"));
        System.out.println("章".getBytes("GBK"));
        System.out.println(Charset.defaultCharset());
    }
}
