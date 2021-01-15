package com.zhang.springboot.oss;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Date;

@Component
public class OssUtils {
    //public static
    private static String endpoint;

    private static String accessKeyId;

    private static String accessKeySecret;

    private static String bucketName;

    //@Value("${mstr.oss.endpoint}")
    public  void setEndpoint(String endpoint) {
        OssUtils.endpoint = endpoint;
    }

    //@Value("${mstr.oss.accessKeyId}")
    public  void setAccessKeyId(String accessKeyId) {
        OssUtils.accessKeyId = accessKeyId;
    }

    //@Value("${mstr.oss.accessKeySecret}")
    public  void setAccessKeySecret(String accessKeySecret) {
        OssUtils.accessKeySecret = accessKeySecret;
    }

    //@Value("${mstr.oss.bucketName}")
    public  void setBucketName(String bucketName) {
        OssUtils.bucketName = bucketName;
    }

    public static String uploadFile(File file){
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        ObjectMetadata meta = new ObjectMetadata();
        meta.setContentType("application/octet-stream");
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName,file.getPath(),file);
        putObjectRequest.setMetadata(meta);
        ossClient.putObject(putObjectRequest);
        String url = ossClient.generatePresignedUrl(bucketName,file.getPath(),new Date(new Date().getTime()+3600L*1000L*24L*365L*10L)).toString();
        System.out.println(url);
        ossClient.shutdown();
        return url;
    } 
}
