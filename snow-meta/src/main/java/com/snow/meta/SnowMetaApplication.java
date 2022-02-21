package com.snow.meta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableFeignClients
@EnableDiscoveryClient
@EnableAsync
@SpringBootApplication(scanBasePackages = {"com.snow"})
public class SnowMetaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SnowMetaApplication.class, args);
    }

}
