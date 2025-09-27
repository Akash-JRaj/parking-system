package com.akashjayaraj.parkingsystem.service;

import com.akashjayaraj.parkingsystem.exception.InvalidFloorOperationException;
import com.akashjayaraj.parkingsystem.model.Floor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class FloorService {

    private Map<Integer, Floor> floors = new TreeMap<>();

    public void addFloor(int floorNo, Floor floor) {

        if(floors.containsKey(floorNo)) {
            throw new InvalidFloorOperationException("Floor with floor no already exists");
        }

        floors.put(floorNo, floor);
    }

    public Floor getBestFloor() {
        for(Map.Entry<Integer, Floor> entry : floors.entrySet()) {
            if(!entry.getValue().getAvailableSlots().isEmpty()) {
                return entry.getValue();
            }
        }
        return null;
    }

    public Floor getFloor(int floorNo) {
        if(!floors.containsKey(floorNo)) {
            throw new InvalidFloorOperationException("Floor not found");
        }

        return floors.get(floorNo);
    }

    public List<Floor> getAllAvailableFloor() {
        List<Floor> availableFloors = new ArrayList<>();
        for(Map.Entry<Integer, Floor> entry : floors.entrySet()) {
            if(!entry.getValue().getAvailableSlots().isEmpty()) {
                availableFloors.add(entry.getValue());
            }
        }
        return availableFloors;
    }
}
