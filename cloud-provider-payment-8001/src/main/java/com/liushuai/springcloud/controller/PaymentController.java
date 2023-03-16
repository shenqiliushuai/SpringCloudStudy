package com.liushuai.springcloud.controller;

import com.liushuai.springcloud.entities.CommonResult;
import com.liushuai.springcloud.entities.Payment;
import com.liushuai.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult<?> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        if (result >= 0) {
            log.info("写入成功！");
            return new CommonResult<>(200, "写入成功serverPort" + serverPort);
        } else {
            log.error("写入失败！");
            return new CommonResult<>(444, "写入失败serverPort" + serverPort);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<?> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new CommonResult<>(200, "查询成功serverPort" + serverPort, payment);
        } else {
            return new CommonResult<>(444, "无记录serverPort" + serverPort);
        }
    }

    @GetMapping("payment/discovery")
    public Object discovery() {
        List<String> clientServices = discoveryClient.getServices();
        clientServices.forEach(log::info);
        List<ServiceInstance> instanceList = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance : instanceList) {
            log.info("id:{},host:{},port:{},uri:{}", instance.getServiceId(), instance.getHost(),
                    instance.getPort(), instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/payment/lb")
    public String getPaymentLb() {
        return serverPort;
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    // -----------------> zipkin + sleuth
    @GetMapping("/payment/zipkin")
    public String paymentZipkin(){
        return "hi, i'am paymentzipkin server full back, welcome to lshuai, O(∩_∩)O哈哈~";
    }
}
