package com.Project.TransactionManagementService.feign;

import com.Project.TransactionManagementService.dto.CarDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "car-management-service", url = "http://localhost:6969/cars") // Replace with actual service name and URL
public interface CarServiceClient {
    @GetMapping("/{carId}")
    ResponseEntity<CarDto> getCarById(@PathVariable Long carId);
}
