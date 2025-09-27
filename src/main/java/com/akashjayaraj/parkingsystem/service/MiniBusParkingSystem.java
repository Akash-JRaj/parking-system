package com.akashjayaraj.parkingsystem.service;

import com.akashjayaraj.parkingsystem.strategy.ParkingSlotNearExitStrategy;

public class MiniBusParkingSystem extends ParkingSystem{
    public MiniBusParkingSystem(ParkingSlotNearExitStrategy strategy, FloorService floorService) {
        super(strategy, floorService);
    }
}
