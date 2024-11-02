package com.tyut.minio01;

import com.tyut.minio01.service.MinIOService;
import io.minio.*;
import io.minio.errors.*;
import io.minio.http.Method;
import io.minio.messages.Bucket;
import io.minio.messages.Item;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class Minio01ApplicationTests {

    @Resource
    private MinIOService minIOService;

    @Resource
    private MinioClient minioClient;

    @Test
    void contextLoads() {
        minIOService.testMinIOClient();
    }

    @Test
    void test01() throws Exception {
        // 用于检查指定的存储桶是否存在，返回布尔值，表示存储桶是否存在
        boolean exists = minioClient.bucketExists(
                BucketExistsArgs
                        .builder()
                        .bucket("myfile")
                        .build());
        System.out.println("myfile数据桶是否存在：" + exists);
    }

    @Test
    void test02() throws Exception {
        // 用于创建一个新的存储桶（bucket），需要指定存储桶的名称
        minioClient.makeBucket(
                MakeBucketArgs
                        .builder()
                        .bucket("myfile")
                        .build());
    }

    @Test
    void test03() throws Exception {
        // 用于列出用户有权访问的所有存储桶，返回存储桶的列表
        List<Bucket> buckets = minioClient.listBuckets();
        buckets.forEach(b -> System.out.println(b.name() + " -- " + b.creationDate()));
    }

    @Test
    void test04() throws Exception {
        // 用于删除一个已存在的存储桶（bucket），删除失败会抛出异常；
        minioClient.removeBucket(
                RemoveBucketArgs
                        .builder()
                        .bucket("myfile")
                        .build());
    }

    @Test
    void test05() throws Exception {
        File file = new File("C:\\Users\\HX\\Desktop\\郭家旗\\图片\\basketall.png");
        // 用于上传文件到指定的存储桶；
        ObjectWriteResponse objectWriteResponse = minioClient.putObject(PutObjectArgs.builder()
                .bucket("files2")
                .object("test.png")
                .stream(new FileInputStream(file), file.length(), -1)
                .build());
        System.out.println(objectWriteResponse);

        // 直接指定要上传的文件路径
        ObjectWriteResponse objectWriteResponse1 = minioClient.uploadObject(UploadObjectArgs.builder()
                .bucket("files2")
                .object("test2.jpg")
                .filename("C:\\Users\\HX\\Desktop\\郭家旗\\侯子.png")
                .build());
        System.out.println(objectWriteResponse1);
    }

    @Test
    void test06() throws Exception {
        //用于检查指定的对象（文件）的状态
        StatObjectResponse files = minioClient.statObject(StatObjectArgs.builder()
                .bucket("files")
                .object("test.png")
                .build());
        System.out.println(files.size());
    }

    @Test
    void test07() throws Exception {
        //用于生成一个对象（文件）的签名URL，以便可以通过HTTP访问
        String url = minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder()
                .bucket("files")
                .object("test.png")
                .expiry(3, TimeUnit.MINUTES) // 3分钟有效
                .method(Method.GET) // GET方法
                .build());
        System.out.println(url);
    }


    @Test
    void test08() throws Exception {
        String bucketName = "files2";
        //生成桶
        minioClient.makeBucket(MakeBucketArgs.builder()
                .bucket(bucketName)
                .build());
        String policyJsonString = "{\"Version\":\"2012-10-17\",\"Statement\":[{\"Sid\":\"PublicRead\",\"Effect\":\"Allow\",\"Principal\":{\"AWS\":\"*\"},\"Action\":[\"s3:GetObject\"],\"Resource\":[\"arn:aws:s3:::" + bucketName + "/*\"]}]}";
        // 创建存储桶的时候，设置该存储桶里面的文件的访问策略，允许公开的读
        minioClient.setBucketPolicy(SetBucketPolicyArgs.builder()
                .bucket(bucketName)
                .config(policyJsonString)
                .build());
    }

    @Test
    void test09() throws Exception {
        // 用于从指定的存储桶中下载文件
        GetObjectResponse minioClientObject = minioClient.getObject(GetObjectArgs.builder()
                .bucket("files")
                .object("test.png")
                .build());
        System.out.println(minioClientObject.transferTo(new FileOutputStream("D:\\Edge文件收藏\\123.png")));
    }

    @Test
    void test10() throws Exception {
        // 用于列出指定存储桶中的所有对象（文件）
        Iterable<Result<Item>> listObjects = minioClient.listObjects(ListObjectsArgs.builder()
                .bucket("files")
                .build());
        listObjects.forEach(r -> {
            try {
                Item item = r.get();
                System.out.println(item.objectName());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Test
    void test11() throws Exception {
        // 用于删除指定存储桶中的对象，需要指定存储桶名称和对象键
        minioClient.removeObject(RemoveObjectArgs.builder()
                .bucket("files")
                .object("test.png")
                .build());
    }
}
