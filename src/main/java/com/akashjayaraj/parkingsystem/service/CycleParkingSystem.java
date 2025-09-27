package com.akashjayaraj.parkingsystem.service;

import com.akashjayaraj.parkingsystem.strategy.ParkingSlotFloorAndExitStrategy;
import com.akashjayaraj.parkingsystem.strategy.ParkingSlotNearExitStrategy;
import org.springframework.stereotype.Service;

@Service
public class CycleParkingSystem extends ParkingSystem{
    //We can make use of these classes wherever we require in our design
    public CycleParkingSystem(ParkingSlotNearExitStrategy parkingSlotNearExitStrategy, FloorService floorService, ParkingSlotFloorAndExitStrategy parkingSlotFloorAndExitStrategy) {
        super(parkingSlotNearExitStrategy, floorService, parkingSlotFloorAndExitStrategy);
    }
}
