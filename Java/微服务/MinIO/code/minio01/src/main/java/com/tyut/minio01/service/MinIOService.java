package com.tyut.minio01.service;

import io.minio.MinioClient;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @version v1.0
 * @author OldGj 2024/10/31
 * @apiNote MinIO服务类
 */
@Service
public class MinIOService {

    @Resource
    private MinioClient minioClient;


    public void testMinIOClient() {
        System.out.println(minioClient);
    }
}
