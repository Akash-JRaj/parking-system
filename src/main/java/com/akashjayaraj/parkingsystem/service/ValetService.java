package com.akashjayaraj.parkingsystem.service;

import com.akashjayaraj.parkingsystem.model.ParkingTicket;
import com.akashjayaraj.parkingsystem.model.User;
import com.akashjayaraj.parkingsystem.model.Valet;
import org.springframework.stereotype.Service;

@Service
public class ValetService {

    private ValetManagementService valetManagementService;
    private EntryGate entryGate;
    private ExitGate exitGate;

    public ValetService(ValetManagementService valetManagementService, EntryGate entryGate, ExitGate exitGate) {
        this.valetManagementService = valetManagementService;
        this.entryGate = entryGate;
        this.exitGate = exitGate;
    }

    public Valet getValet() {
        return valetManagementService.getValetWithMoreSkill();
    }

    public void freeValet(Valet valet) {
        valetManagementService.freeValet(valet);
    }

    public ParkingTicket getTicket(User user) {
        return entryGate.getTicket(user);
    }

    //some more functions related to valet service.
}
