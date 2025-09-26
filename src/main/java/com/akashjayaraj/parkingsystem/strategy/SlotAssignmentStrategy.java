package com.akashjayaraj.parkingsystem.strategy;

import com.akashjayaraj.parkingsystem.model.ParkingSlot;

import java.util.Set;

public interface SlotAssignmentStrategy {
    ParkingSlot getParkingSlot(Set<ParkingSlot> availableSlots);
}
