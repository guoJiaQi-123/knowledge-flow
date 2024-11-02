package com.tyut.miniospringboot;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.tyut.miniospringboot.mapper")
@Slf4j
public class MinioSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MinioSpringbootApplication.class, args);
        log.info("*****项目启动成功*****");
    }

}
