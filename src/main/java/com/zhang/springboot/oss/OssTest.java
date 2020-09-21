package com.zhang.springboot.oss;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.PutObjectRequest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class OssTest {
    private static  String endpoint = "http://oss-cn-gz-devgdrccloud-d01-a.ops.dev-cloud.96138.com.cn/edasp-sit-bucket";

    private static  String accessKeyId = "ymUl4aMh8Is448Td";

    private static  String accessKeySecret = "cVuf3ufwWc5iROQ56R3PbMnTJsDUaa";

    private static  String bucketName = "edasp-sit-bucket";

    public static void upload() throws FileNotFoundException {
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 创建PutObjectRequest对象。
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, "ossTest.txt", new File("G:\\ossTest.txt"));
        // 上传文件。
        ossClient.putObject(putObjectRequest);
        // 关闭OSSClient。
        ossClient.shutdown();
    }

    public void downFile(){
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 下载OSS文件到本地文件。如果指定的本地文件存在会覆盖，不存在则新建。
        ossClient.getObject(new GetObjectRequest(bucketName, "ossTest.txt"), new File("F:\\ossTest.txt"));
        // 关闭OSSClient。
        ossClient.shutdown();
    }

    public static void main(String[] args) throws FileNotFoundException {
        upload();
    }
}
