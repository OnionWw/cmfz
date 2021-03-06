package com.wucong.cmfz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

    @SpringBootApplication
    @MapperScan("com.wucong.cmfz.mapper")
    public class CmfzApplication {

    public static void main(String[] args) {

        SpringApplication.run(CmfzApplication.class, args);
    }

}

