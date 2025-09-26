package com.akashjayaraj.parkingsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ParkingSlot {
    private long id;
    private boolean occupied;
    private long distanceToExit;
}
