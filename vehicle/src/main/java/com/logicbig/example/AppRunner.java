package com.logicbig.example;

import com.logicbig.example.client.OrderServiceClient;
import com.logicbig.example.service.OrderService;
import com.logicbig.example.service.impl.OrderServiceImpl1;
import com.logicbig.example.service.impl.OrderServiceImpl2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppRunner {

    @Bean(name = "OrderServiceA")
    public OrderService orderServiceByProvider1() {
        return new OrderServiceImpl1();
    }

    @Bean(name = "OrderServiceB")
    public OrderService orderServiceByProvider2() {
        return new OrderServiceImpl2();
    }

    @Bean
    public OrderServiceClient createClient() {
        return new OrderServiceClient();
    }

    public static void main(String... strings) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppRunner.class);
        OrderServiceClient bean = context.getBean(OrderServiceClient.class);
        bean.showPendingOrderDetails();
    }
}