package com.zhang.springboot.io.bio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadBigFile {

  public boolean readFile(String path) throws IOException {
      File file = new File(path);
      InputStream is = new FileInputStream(file);
      byte[] buffer = new byte[1024];
      while(is.read(buffer)>1){
        String str= new String (buffer);
        System.out.println(str);
        break;
        //byteInputStream.write(buffer);
      }
      //Long length = file.length();
      //byte[] bytes = new byte[length.intValue()];
      return true;
  }

  public static void main(String[] args) throws IOException {
    ReadBigFile readBigFile = new ReadBigFile();
    readBigFile.readFile("E:\\test.rar");
  }

}
