package com.akashjayaraj.parkingsystem.service;

import com.akashjayaraj.parkingsystem.strategy.ParkingSlotNearExitStrategy;
import org.springframework.stereotype.Service;

@Service
public class BikeParkingSystem extends ParkingSystem{
    public BikeParkingSystem(ParkingSlotNearExitStrategy strategy, FloorService floorService) {
        super(strategy, floorService);
    }
}
