package com.liushuai.springcloud.service.impl;

import com.liushuai.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Service;

@Service
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentHystrixServiceImpl fallback paymentInfo_OK...";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentHystrixServiceImpl fallback paymentInfo_TimeOut";
    }
}
