package com.akashjayaraj.parkingsystem.service;

import com.akashjayaraj.parkingsystem.exception.InvalidAadhaarException;
import com.akashjayaraj.parkingsystem.model.*;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ExitGate extends Gate {

    private ParkingSystem parkingSystem;
    private IdentityService identityService;
    private InsuranceService insuranceService;
    private ValetService valetService;

    public ExitGate(ParkingSystem parkingSystem, IdentityService identityService, InsuranceService insuranceService, ValetService valetService) {
        this.parkingSystem = parkingSystem;
        this.identityService = identityService;
        this.insuranceService = insuranceService;
        this.valetService = valetService;
    }


    public String acceptTicket(User user) {
        ParkingTicket ticket = user.getTicket();

        if(!ticket.getAadhaarId().equals(user.getAadhaarId())) {
            throw new InvalidAadhaarException("Aadhaar from ticket doesn't match the user!");
        }
        user.setTicket(null);
        user.setInsurance(null);
        parkingSystem.releaseSlot(ticket);
        Valet valet = valetService.getValet();
        // Use the valet to get the car to the user and close it.

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
