package com.zhang.springboot.reflect;

import com.zhang.springboot.collection.BillsNums;
import com.zhang.springboot.collection.TestBillsNums;

import java.io.*;
import java.lang.reflect.Method;

public class MyClassLoad extends ClassLoader{
    private String rootPath;

    public MyClassLoad(String rootPath) {
        this.rootPath = rootPath;
    }
    /**
     * 根据name来寻找该类
     *
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> c = findLoadedClass(name);
        if (c == null) { // 内存堆中还没加载该类
            c = findMyClass(name); // 自己实现加载类
        }
        return c;
    }

    /**
     * 加载该类
     *
     * @param name
     * @return
     */
    private Class<?> findMyClass(String name) {
        try {
            byte[] bytes = getData(name);
            return this.defineClass(null, bytes, 0, bytes.length); // 调用父类方法，生成具体类
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private byte[] getData(String className) {
        String path = rootPath + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
        InputStream is = null;
        try {
            is = new FileInputStream(path);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            byte[] buffer = new byte[2048];
            int num = 0;
            while ((num = is.read(buffer)) != -1) {
                stream.write(buffer, 0, num);
            }
            return stream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //会报错然后认为不是一个类，强转后会失败
        //MyClassLoad myClassLoad = new MyClassLoad("G:\\IdeaPj\\myPJ\\mySpringboot\\target\\classes\\com\\zhang\\springboot\\collection");
        MyClassLoad myClassLoad = new MyClassLoad("G:\\IdeaPj\\myPJ\\mySpringboot\\target\\classes\\");
        //name是唯一的全类名，否则会报强转失败,只能用接口指定
        Class clazz = myClassLoad.findClass("com.zhang.springboot.collection.BillsNums");
        System.out.println(clazz.newInstance());
        //使用接口来接受，不能使用具体的类，否则会报错
        TestBillsNums object = (TestBillsNums) clazz.newInstance();
        //BillsNums object = (BillsNums)clazz.newInstance();
        System.out.println(object.getClass().toString());
        object.test();
//        Method method = clazz.g
//        billsNums.setName("haha");
//
//        Class<?> claszz = Class.forName("com.zhang.springboot.collection.BillsNums");
//        BillsNums billsNums = (BillsNums) claszz.newInstance();
//        billsNums.setName("hhh");
//        System.out.println(billsNums);
    }
}
