package com.logicbig.example.service.impl;

import com.logicbig.example.service.OrderService;

public class OrderServiceImpl2 implements OrderService {

    public String getOrderDetails(String orderId) {
        return "Order details from impl 2, for order id=" + orderId;
    }
}