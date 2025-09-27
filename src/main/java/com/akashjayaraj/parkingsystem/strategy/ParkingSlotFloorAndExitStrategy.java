package com.akashjayaraj.parkingsystem.strategy;

import com.akashjayaraj.parkingsystem.model.Floor;
import com.akashjayaraj.parkingsystem.model.ParkingSlot;
import com.akashjayaraj.parkingsystem.service.FloorService;

import java.util.Set;

public class ParkingSlotFloorAndExitStrategy implements SlotAssignmentStrategy{

    private FloorService floorService;

    public ParkingSlotFloorAndExitStrategy(FloorService floorService) {
        this.floorService = floorService;
    }

    @Override
    public ParkingSlot getParkingSlot(Set<ParkingSlot> availableSlots) {
        Floor bestFloor = floorService.getBestFloor();
        return bestFloor.getParkingSlots().poll();
    }
}
