package com.akashjayaraj.parkingsystem.controller;

import com.akashjayaraj.parkingsystem.model.Floor;
import com.akashjayaraj.parkingsystem.service.FloorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/floors")
public class FloorController {

    private FloorService floorService;

    public FloorController(FloorService floorService) {
        this.floorService = floorService;
    }

    @GetMapping
    public ResponseEntity<List<Floor>> getAllFloors() {
        return ResponseEntity.status(HttpStatus.OK).body(floorService.getAllFloors());
    }

}
