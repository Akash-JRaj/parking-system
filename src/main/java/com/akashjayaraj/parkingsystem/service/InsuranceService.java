package com.akashjayaraj.parkingsystem.service;

import com.akashjayaraj.parkingsystem.model.Insurance;
import com.akashjayaraj.parkingsystem.model.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Service
public class InsuranceService {

    public void assignPremiumPolicyToUser(User user) {
        user.setInsurance(getPremiumInsurance());
    }

    public void assignNormalPolicyToUser(User user) {
        user.setInsurance(getNormalInsurance());
    }

    public Insurance getNormalInsurance() {
        Insurance insurance = new Insurance();
        insurance.setId(Math.abs(new Random().nextLong()));
        insurance.setStatus("Normal");
        insurance.setCoverageAmount(100000L);
        insurance.setIssuedAt(new Date());
        return insurance;
    }

    public Insurance getPremiumInsurance() {
        Insurance insurance = new Insurance();
        insurance.setId(Math.abs(new Random().nextLong()));
        insurance.setStatus("Premium");
        insurance.setCoverageAmount(1000000L);
        insurance.setIssuedAt(new Date());
        return insurance;
    }

}
