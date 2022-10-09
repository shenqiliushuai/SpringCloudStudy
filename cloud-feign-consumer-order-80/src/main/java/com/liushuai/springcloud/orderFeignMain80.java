package com.liushuai.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class orderFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(orderFeignMain80.class, args);
    }
}
