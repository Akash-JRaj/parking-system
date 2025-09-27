package com.akashjayaraj.parkingsystem.model;

import lombok.Data;

@Data
public class Valet {
    private Long id;
    private String name;
    private Integer skillRank;
    private boolean isAvailable;
}
