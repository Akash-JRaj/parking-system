package com.akashjayaraj.parkingsystem.controller;

import com.akashjayaraj.parkingsystem.model.User;
import com.akashjayaraj.parkingsystem.service.EntryGate;
import com.akashjayaraj.parkingsystem.service.ExitGate;
import com.akashjayaraj.parkingsystem.model.ParkingSlot;
import com.akashjayaraj.parkingsystem.model.ParkingTicket;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParkingSystemController {

    private EntryGate entryGate;
    private ExitGate exitGate;

    public ParkingSystemController(EntryGate entryGate, ExitGate exitGate) {
        this.entryGate = entryGate;
        this.exitGate = exitGate;
    }

    @GetMapping("/enter")
    public ResponseEntity<ParkingTicket> enter(@RequestBody User user) {
        ParkingTicket ticket = entryGate.getTicket(user);

        return ResponseEntity.status(HttpStatus.OK).body(ticket);
    }

    @PostMapping("/exit")
    public ResponseEntity<String> exit(@RequestBody User user) {
        String response = exitGate.acceptTicket(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/slots")
    public ResponseEntity<List<ParkingSlot>> getAvailableSlots() {
        return ResponseEntity.status(HttpStatus.OK).body(entryGate.getAvailableSlots());
    }
}
