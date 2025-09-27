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

    private ParkingService parkingService;
    private IdentityService identityService;
    private InsuranceService insuranceService;

    public EntryGate(ParkingService parkingService, IdentityService identityService, InsuranceService insuranceService) {
        this.parkingService = parkingService;
        this.identityService = identityService;
        this.insuranceService = insuranceService;
    }

    public ParkingTicket getTicket(User user) {

        if(!identityService.isVerifiedUser(user)) {
            identityService.register(user);
        }

        ParkingTicket ticket = new ParkingTicket();

        ticket.setId(parkingService.generateRandomId());
        ticket.setSlotId(parkingService.assignSlot().getId());
        ticket.setIssuedAt(new Date());
        ticket.setUserId(user.getId());
        ticket.setAadhaarId(user.getAadhaarId());

        user.setTicket(ticket);
        user.setInsurance(insuranceService.getPremiumInsurance());

        return ticket;
    }

    public List<ParkingSlot> getAvailableSlots() {
        return parkingService.getAvailableSlots();
    }

}
