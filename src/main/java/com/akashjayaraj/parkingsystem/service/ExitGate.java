package com.akashjayaraj.parkingsystem.service;

import com.akashjayaraj.parkingsystem.exception.InvalidAadhaarException;
import com.akashjayaraj.parkingsystem.model.Gate;
import com.akashjayaraj.parkingsystem.model.ParkingTicket;
import com.akashjayaraj.parkingsystem.model.TheftReport;
import com.akashjayaraj.parkingsystem.model.User;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ExitGate extends Gate {

    private ParkingSystem parkingSystem;
    private IdentityService identityService;
    private InsuranceService insuranceService;

    public ExitGate(ParkingSystem parkingSystem, IdentityService identityService, InsuranceService insuranceService) {
        this.parkingSystem = parkingSystem;
        this.identityService = identityService;
        this.insuranceService = insuranceService;
    }


    public String acceptTicket(User user) {
        ParkingTicket ticket = user.getTicket();

        if(!ticket.getAadhaarId().equals(user.getAadhaarId())) {
            throw new InvalidAadhaarException("Aadhaar from ticket doesn't match the user!");
        }
        user.setTicket(null);
        user.setInsurance(null);
        parkingSystem.releaseSlot(ticket);

        return "Released slot " + ticket.getSlotId();
    }

    public TheftReport reportTheft(Long userId) {
        User user = identityService.getUserByUserId(userId);

        TheftReport theftReport = new TheftReport();
        theftReport.setId(Math.abs(new Random().nextLong()));
        theftReport.setUserId(userId);
        theftReport.setDescription("abc");
        theftReport.setLawRefId("refid_123");
        theftReport.setStatus("Active");

        parkingSystem.addReport(theftReport);

        return theftReport;
    }
}
