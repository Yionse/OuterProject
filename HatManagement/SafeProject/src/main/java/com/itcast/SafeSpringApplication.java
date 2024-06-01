package com.itcast;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@SpringBootApplication
@EnableTransactionManagement
public class SafeSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(SafeSpringApplication.class,args);
        log.info("项目启动成功");
    }
}
