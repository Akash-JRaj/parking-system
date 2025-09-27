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

    public EntryGate(ParkingService parkingService, IdentityService identityService) {
        this.parkingService = parkingService;
        this.identityService = identityService;
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

        return ticket;
    }

    public List<ParkingSlot> getAvailableSlots() {
        return parkingService.getAvailableSlots();
    }

}
