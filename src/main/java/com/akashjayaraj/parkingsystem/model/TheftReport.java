package com.akashjayaraj.parkingsystem.model;

import lombok.Data;

@Data
public class TheftReport {
    private Long id;
    private Long userId;
    private String status;
    private String lawRefId;
    private String description;
}
