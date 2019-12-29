package com.leyou;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.leyou.goods.mapper")
public class LyGoodsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LyGoodsServiceApplication.class);
    }
}
