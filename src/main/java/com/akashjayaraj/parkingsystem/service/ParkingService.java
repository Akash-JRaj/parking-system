package com.akashjayaraj.parkingsystem.service;

import com.akashjayaraj.parkingsystem.model.Floor;
import com.akashjayaraj.parkingsystem.model.ParkingSlot;
import com.akashjayaraj.parkingsystem.model.ParkingTicket;
import com.akashjayaraj.parkingsystem.model.TheftReport;
import com.akashjayaraj.parkingsystem.strategy.ParkingSlotFloorAndExitStrategy;
import com.akashjayaraj.parkingsystem.strategy.ParkingSlotNearExitStrategy;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ParkingService {

    private ParkingSlotNearExitStrategy parkingSlotNearExitStrategy;
    private ParkingSlotFloorAndExitStrategy parkingSlotFloorAndExitStrategy;

    private FloorService floorService;

    Set<ParkingSlot> slots = new HashSet<>();
    Map<Long, ParkingSlot> slotMap = new HashMap<>();
    private List<TheftReport> reports = new ArrayList<>();

    public ParkingService(ParkingSlotNearExitStrategy parkingSlotNearExitStrategy, FloorService floorService, ParkingSlotFloorAndExitStrategy parkingSlotFloorAndExitStrategy) {
        this.parkingSlotNearExitStrategy = parkingSlotNearExitStrategy;
        this.floorService = floorService;
        this.parkingSlotFloorAndExitStrategy = parkingSlotFloorAndExitStrategy;

        for(int i = 1; i <= 10; i++) {
            ParkingSlot slot = new ParkingSlot(i, false, i * 10);
            slots.add(slot);
            slotMap.put(slot.getId(), slot);
        }

        for(int i = 1; i <= 10; i++) {
            Floor floor = new Floor();
            floor.setFloorNo(i);
            floor.setCapacity(448);
            floor.setAvailableSlots(slots);
            PriorityQueue<ParkingSlot> pq = new PriorityQueue<>((a, b) -> Long.compare(a.getDistanceToExit(), b.getDistanceToExit()));
            pq.addAll(slots);
            floor.setParkingSlots(pq);
            floorService.addFloor(i, floor);
        }
    }

    public ParkingSlot assignSlot() {
//        ParkingSlot assignedSlot = parkingSlotNearExitStrategy.getParkingSlot(slots);
        ParkingSlot assignedSlot = parkingSlotFloorAndExitStrategy.getParkingSlot(floorService.getBestFloor().getAvailableSlots());
        slots.remove(assignedSlot);
        return assignedSlot;
    }

    public void releaseSlot(ParkingTicket ticket) {
        ParkingSlot slot = slotMap.get(ticket.getSlotId());

        slots.add(slot);
    }

    public long generateRandomId() {
        Random random = new Random();

        return Math.abs(random.nextLong());
    }

    public List<ParkingSlot> getAvailableSlots() {
        return new ArrayList<>(slots);
    }

    public List<TheftReport> getReports() {
        return reports;
    }

    public void addReport(TheftReport report) {
        reports.add(report);
    }
}
