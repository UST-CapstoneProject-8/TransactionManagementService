package com.Project.TransactionManagementService.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long userId;
    private String name;
    private String email;
    private String phoneNumber;
}

