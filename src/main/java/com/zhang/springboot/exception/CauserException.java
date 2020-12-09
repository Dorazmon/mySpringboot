package com.zhang.springboot.exception;

public class CauserException {
    public static void main(String[] args) {
        Throwable cause = new Exception("异常1");
        throw new RuntimeException("异常2",cause);
    }
}
