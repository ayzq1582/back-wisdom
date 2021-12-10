package com.zhy.wisdom;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
@MapperScan(basePackages = "com.zhy.wisdom.dao")
//@PropertySource(value = {"log4j.yml"})
public class WisdomApplication {    

    public static void main(String[] args) {
        SpringApplication.run(WisdomApplication.class, args);
    }

}
