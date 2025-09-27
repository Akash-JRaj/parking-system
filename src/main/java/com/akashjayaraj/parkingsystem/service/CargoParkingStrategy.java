package com.akashjayaraj.parkingsystem.service;

import com.akashjayaraj.parkingsystem.strategy.ParkingSlotNearExitStrategy;
import com.akashjayaraj.parkingsystem.strategy.SlotAssignmentStrategy;
import org.springframework.stereotype.Service;

@Service
public class CargoParkingStrategy extends ParkingSystem{
    public CargoParkingStrategy(ParkingSlotNearExitStrategy strategy, FloorService floorService) {
        super(strategy, floorService);
    }
}
