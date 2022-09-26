package com.logicbig.example.client;

import com.logicbig.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import java.util.Arrays;

public class OrderServiceClient {

    @Autowired
    @Qualifier("OrderServiceL")
    private OrderService orderService;

    public void showPendingOrderDetails () {
        for (String orderId : Arrays.asList("100", "200", "300")) {
            System.out.println(orderService.getOrderDetails(orderId));
        }
    }
}