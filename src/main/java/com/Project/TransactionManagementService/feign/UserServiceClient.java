package com.Project.TransactionManagementService.feign;

import com.Project.TransactionManagementService.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "UserManagementService", url = "http://localhost:2025/users") // Replace with actual service name and URL
public interface UserServiceClient {
    @GetMapping("/{userId}")
    ResponseEntity<UserDto> getUserById(@PathVariable Long userId);
}

