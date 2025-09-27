package com.akashjayaraj.parkingsystem.service;

import com.akashjayaraj.parkingsystem.strategy.ParkingSlotFloorAndExitStrategy;
import com.akashjayaraj.parkingsystem.strategy.ParkingSlotNearExitStrategy;
import org.springframework.stereotype.Service;

@Service
public class CarParkingSystem extends ParkingSystem{
    public CarParkingSystem(ParkingSlotNearExitStrategy parkingSlotNearExitStrategy, FloorService floorService, ParkingSlotFloorAndExitStrategy parkingSlotFloorAndExitStrategy) {
        super(parkingSlotNearExitStrategy, floorService, parkingSlotFloorAndExitStrategy);
    }

    //we can add our methods and override the methods we may need to change.
}
