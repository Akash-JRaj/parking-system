package com.akashjayaraj.parkingsystem.model;

import lombok.Data;

import java.util.Date;

@Data
public class Insurance {
    private Long id;
    private Long userId;
    private String status;
    private Long coverageAmount;
    private Date issuedAt;
}
