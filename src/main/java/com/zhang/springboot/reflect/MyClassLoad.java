package com.zhang.springboot.reflect;

import com.zhang.springboot.utils.FileUtil;

import java.io.*;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class MyClassLoad extends ClassLoader{
    private String rootPath;

    public MyClassLoad(String rootPath) {
        this.rootPath = rootPath;
    }

    public MyClassLoad() {

    }

    public boolean havaLoad(String className){
        Class<?> c = findLoadedClass(className);
        if(c==null){
            return false;
        }else{
            return true;
        }
    }

    /**
     * 根据name来寻找该类,不同的类加载器,加载到内存中，不共享
     *
     */
    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
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
            //核心方法loadClass
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

    public Class<?> getClassByInputstream(InputStream is) throws IOException {
        byte[] buffer=new byte[1024];
        int len=0;
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        while((len=is.read(buffer))!=-1){
            bos.write(buffer,0,len);
        }
        bos.flush();
        byte[] byteClass = bos.toByteArray();
        return this.defineClass(null, byteClass, 0, byteClass.length); // 调用父类方法，生成具体类
    }

    public Class<?> getClassByJar(String jarName,String ClassName) throws IOException, IllegalAccessException, InstantiationException {
        URL url = Thread.currentThread().getContextClassLoader().getResource(jarName);
        InputStream is = url.openStream();
        File file = FileUtil.saveTempFile(is,"G://test/tempFile.jar");
        ZipFile zf = new ZipFile(file);
        InputStream in = new BufferedInputStream(new FileInputStream(file));
        ZipInputStream zin = new ZipInputStream(in);
        ZipEntry ze;
        Class clazz = null;
        while ((ze = zin.getNextEntry()) != null) {
            if (ze.isDirectory()) {
            } else {
                if(ze.getName().equals(ClassName)){
                    InputStream apiClass = zf.getInputStream(ze);
                    MyClassLoad myClassLoad = new MyClassLoad();
                    clazz = myClassLoad.getClassByInputstream(apiClass);
                    System.out.println(clazz.newInstance().getClass().getClassLoader());
                    //FileUtil.saveTempFile(apiClass,"G://test/ApiException.class");
                    System.out.println(apiClass);
                }
            }
        }
        zin.closeEntry();
        return clazz;
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, IOException {
        MyClassLoad myClassLoad = new MyClassLoad();
        myClassLoad.getClassByJar("taobao.jar","com/taobao/api/ApiException.class");
    }
}
