package com.liushuai.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class ConsulOrderController {
    //public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://consul-consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consul/consumer/payment")
    public String getPayment() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/consul", String.class);
    }
}
