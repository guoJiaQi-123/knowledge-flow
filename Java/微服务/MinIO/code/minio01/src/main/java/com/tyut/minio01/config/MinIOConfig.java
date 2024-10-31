package com.tyut.minio01.config;

import io.minio.MinioClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version v1.0
 * @author OldGj 2024/10/31
 * @apiNote minio配置类
 */
@Configuration
public class MinIOConfig {

    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint("http://192.168.66.200:9000")
                .credentials("admin", "password")
                .build();
    }
}
