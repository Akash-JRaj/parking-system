package com.akashjayaraj.parkingsystem.model;

import lombok.Data;

import java.util.PriorityQueue;
import java.util.Set;

@Data
public class Floor {
    private int floorNo;
    private int capacity;
    private PriorityQueue<ParkingSlot> parkingSlots;
    private Set<ParkingSlot> availableSlots;
    private Set<ParkingSlot> occupiedSlots;
}
