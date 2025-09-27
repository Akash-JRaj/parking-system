package com.akashjayaraj.parkingsystem.service;

import com.akashjayaraj.parkingsystem.exception.InvalidAadhaarException;
import com.akashjayaraj.parkingsystem.model.Gate;
import com.akashjayaraj.parkingsystem.model.ParkingTicket;
import com.akashjayaraj.parkingsystem.model.User;
import org.springframework.stereotype.Component;

@Component
public class ExitGate extends Gate {

    private ParkingService parkingService;
    private IdentityService identityService;

    public ExitGate(ParkingService parkingService, IdentityService identityService) {
        this.parkingService = parkingService;
        this.identityService = identityService;
    }


    public String acceptTicket(User user) {
        ParkingTicket ticket = user.getTicket();

        if(!ticket.getAadhaarId().equals(user.getAadhaarId())) {
            throw new InvalidAadhaarException("Aadhaar from ticket doesn't match the user!");
        }
        user.setTicket(null);
        parkingService.releaseSlot(ticket);

        return "Released slot " + ticket.getSlotId();
    }
}
