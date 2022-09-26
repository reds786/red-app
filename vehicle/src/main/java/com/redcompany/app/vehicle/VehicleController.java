package com.redcompany.app.vehicle;

import com.redcompany.app.service.JoinsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/hello")
@AllArgsConstructor
public class VehicleController {
    private final JoinsService joinsService;

    @RequestMapping
    private String favVehicle(){
        joinsService.whenPathExpressionIsUsedForSingleValuedAssociation_thenCreatesImplicitInnerJoin();
             return "R-1!";

    }


   }
