package com.akashjayaraj.parkingsystem.strategy;

import com.akashjayaraj.parkingsystem.model.ParkingSlot;
import org.springframework.stereotype.Component;

import java.util.PriorityQueue;
import java.util.Set;

@Component
public class ParkingSlotNearExitStrategy implements SlotAssignmentStrategy{
    @Override
    public ParkingSlot getParkingSlot(Set<ParkingSlot> availableSlots) {
        PriorityQueue<ParkingSlot> minHeap = new PriorityQueue<>((a, b) -> Long.compare(a.getDistanceToExit(), b.getDistanceToExit()));
        minHeap.addAll(availableSlots);
        return minHeap.poll();
    }
}
