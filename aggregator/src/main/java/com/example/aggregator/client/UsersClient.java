package com.example.aggregator.client;

import com.example.aggregator.dto.UserResponseDto;
import com.example.aggregator.dto.UsersRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "users")
public interface UsersClient {
    @PostMapping("/api/users")
    List<UserResponseDto> getUsers(@RequestBody UsersRequestDto ids);

}
