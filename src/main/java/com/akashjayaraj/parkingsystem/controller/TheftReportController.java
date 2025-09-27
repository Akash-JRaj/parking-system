package com.akashjayaraj.parkingsystem.controller;

import com.akashjayaraj.parkingsystem.model.TheftReport;
import com.akashjayaraj.parkingsystem.service.ExitGate;
import com.akashjayaraj.parkingsystem.service.ParkingSystem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theft")
public class TheftReportController {

    private ParkingSystem parkingSystem;
    private ExitGate exitGate;

    public TheftReportController(ParkingSystem parkingSystem, ExitGate exitGate) {
        this.parkingSystem = parkingSystem;
        this.exitGate = exitGate;
    }

    @PostMapping("/report")
    public ResponseEntity<String> report(@RequestBody TheftReport report) {
        parkingSystem.addReport(report);
        return ResponseEntity.status(HttpStatus.CREATED).body("Reported Successfully");
    }

    @PostMapping("/report/{userId}")
    public ResponseEntity<TheftReport> create(@PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(exitGate.reportTheft(userId));
    }

    @GetMapping("/")
    public ResponseEntity<List<TheftReport>> getAllReports() {
        return ResponseEntity.status(HttpStatus.OK).body(parkingSystem.getReports());
    }
}
