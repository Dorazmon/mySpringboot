package com.zhang.springboot.tomcat.wrapper;

import java.io.PrintWriter;
import java.io.Writer;

public class MyPrintWriter extends PrintWriter {
    private StringBuilder stringBuilder;
    public MyPrintWriter(Writer out) {
        super(out);
        stringBuilder = new StringBuilder();
    }

    @Override
    public void print(String s){
        super.print(s);
        stringBuilder.append(s);
        System.out.println(stringBuilder);
    }

    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }
}
