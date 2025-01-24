package com.Project.TransactionManagementService.dto;

import lombok.Data;

@Data
public class CarDto {
    private Long carId;
    private String make;
    private String model;
    private String status;
    private Long ownerId;
}
