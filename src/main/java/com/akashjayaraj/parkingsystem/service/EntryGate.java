package com.akashjayaraj.parkingsystem.service;

import com.akashjayaraj.parkingsystem.model.Gate;
import com.akashjayaraj.parkingsystem.model.ParkingSlot;
import com.akashjayaraj.parkingsystem.model.ParkingTicket;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class EntryGate extends Gate {

    private ParkingService parkingService;

    public EntryGate(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    public ParkingTicket getTicket() {
        ParkingTicket ticket = new ParkingTicket();

        ticket.setId(parkingService.generateRandomId());
        ticket.setSlotId(parkingService.assignSlot().getId());
        ticket.setIssuedAt(new Date());

        return ticket;
    }

    public List<ParkingSlot> getAvailableSlots() {
        return parkingService.getAvailableSlots();
    }

}
