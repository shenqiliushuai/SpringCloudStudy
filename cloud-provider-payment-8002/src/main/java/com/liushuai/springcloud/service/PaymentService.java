package com.liushuai.springcloud.service;

import com.liushuai.springcloud.entities.Payment;

public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(Long id);
}
