package com.liushuai.springcloud.controller;

import com.liushuai.springcloud.entities.CommonResult;
import com.liushuai.springcloud.entities.Payment;
import com.liushuai.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class FeignOrderController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<?> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeout() {
        //openFeign-ribbon,客户端一般默认等待1秒，Feign设置了3秒
        return paymentFeignService.paymentFeignTimeout();
    }
}
