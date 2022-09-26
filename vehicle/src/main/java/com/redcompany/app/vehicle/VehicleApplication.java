package com.redcompany.app.vehicle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages= {"com.redcompany"})
@ComponentScan("com.redcompany")
public class VehicleApplication {


    public static void main(String[] args) {

        SpringApplication.run(VehicleApplication.class, args);




    }
}





