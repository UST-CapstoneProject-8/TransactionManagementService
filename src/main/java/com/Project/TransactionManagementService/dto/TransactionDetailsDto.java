package com.Project.TransactionManagementService.dto;

import com.Project.TransactionManagementService.model.TransactionEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransactionDetailsDto {
    private TransactionEntity transaction;
    private CarDto car;
    private UserDto buyer;
    private UserDto seller;
}
