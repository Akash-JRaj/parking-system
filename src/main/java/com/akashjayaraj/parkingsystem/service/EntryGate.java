package com.akashjayaraj.parkingsystem.service;

import com.akashjayaraj.parkingsystem.model.Gate;
import com.akashjayaraj.parkingsystem.model.ParkingSlot;
import com.akashjayaraj.parkingsystem.model.ParkingTicket;
import com.akashjayaraj.parkingsystem.model.User;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class EntryGate extends Gate {

    private ParkingSystem parkingSystem;
    private IdentityService identityService;
    private InsuranceService insuranceService;

    public EntryGate(ParkingSystem parkingSystem, IdentityService identityService, InsuranceService insuranceService) {
        this.parkingSystem = parkingSystem;
        this.identityService = identityService;
        this.insuranceService = insuranceService;
    }

    public ParkingTicket getTicket(User user) {

        if(!identityService.isVerifiedUser(user)) {
            identityService.register(user);
        }

        ParkingTicket ticket = new ParkingTicket();

        ticket.setId(parkingSystem.generateRandomId());
        ticket.setSlotId(parkingSystem.assignSlot().getId());
        ticket.setIssuedAt(new Date());
        ticket.setUserId(user.getId());
        ticket.setAadhaarId(user.getAadhaarId());

        user.setTicket(ticket);
        user.setInsurance(insuranceService.getPremiumInsurance());

        return ticket;
    }

    public List<ParkingSlot> getAvailableSlots() {
        return parkingSystem.getAvailableSlots();
    }

}
