package com.lzy12;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 将会自动扫描com.lzy12的包以及其子包的所有文件，但是只是扫描，并不是注入
 * 如果要注入需要component注解或者是bean注解
 */
@SpringBootApplication
@MapperScan("com.lzy12.mapper")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}