package com.akashjayaraj.parkingsystem.service;

import com.akashjayaraj.parkingsystem.model.Gate;
import com.akashjayaraj.parkingsystem.model.ParkingTicket;
import org.springframework.stereotype.Component;

@Component
public class ExitGate extends Gate {

    private ParkingService parkingService;

    public ExitGate(ParkingService parkingService) {
        this.parkingService = parkingService;
    }


    public String acceptTicket(ParkingTicket ticket) {
        parkingService.releaseSlot(ticket);

        return "Released slot " + ticket.getSlotId();
    }
}
