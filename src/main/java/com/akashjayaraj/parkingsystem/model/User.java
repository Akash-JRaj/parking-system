package com.akashjayaraj.parkingsystem.model;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private String contact;
    private String aadhaarId;
    private boolean isVerifiedUser;
    private ParkingTicket ticket;
    private Insurance insurance;
}
