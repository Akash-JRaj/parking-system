package com.akashjayaraj.parkingsystem.controller;

import com.akashjayaraj.parkingsystem.model.Insurance;
import com.akashjayaraj.parkingsystem.service.InsuranceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {

    private InsuranceService insuranceService;

    public InsuranceController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @GetMapping("/purchase/{type}")
    public ResponseEntity<Insurance> purchase(@PathVariable String type) {
        if(type.equals("premium")) {
            return ResponseEntity.status(HttpStatus.OK).body(insuranceService.getPremiumInsurance());
        }
        return ResponseEntity.status(HttpStatus.OK).body(insuranceService.getNormalInsurance());
    }

}
