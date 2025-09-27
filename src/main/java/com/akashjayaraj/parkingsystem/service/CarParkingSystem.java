package com.akashjayaraj.parkingsystem.service;

import com.akashjayaraj.parkingsystem.strategy.ParkingSlotFloorAndExitStrategy;
import com.akashjayaraj.parkingsystem.strategy.ParkingSlotNearExitStrategy;
import org.springframework.stereotype.Service;

public class CarParkingSystem extends ParkingSystem{
    public CarParkingSystem(ParkingSlotFloorAndExitStrategy parkingSlotFloorAndExitStrategy, FloorService floorService) {
        super(parkingSlotFloorAndExitStrategy, floorService);
    }

    //we can add our methods and override the methods we may need to change.
}
