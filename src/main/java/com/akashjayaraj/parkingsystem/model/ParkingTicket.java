package com.akashjayaraj.parkingsystem.model;

import lombok.Data;

import java.util.Date;

@Data
public class ParkingTicket {
    private long id;
    private long slotId;
    private Date issuedAt;
    private long userId;
    private String aadhaarId;
}
