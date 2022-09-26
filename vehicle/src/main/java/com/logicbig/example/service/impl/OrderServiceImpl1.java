package com.logicbig.example.service.impl;

import com.logicbig.example.service.OrderService;

public class OrderServiceImpl1 implements OrderService {

    public String getOrderDetails(String orderId) {
        return "Order details from impl 1, for order id=" + orderId;
    }
}