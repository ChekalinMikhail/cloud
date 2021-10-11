package com.example.data.rest;

import com.example.data.dto.UserResponseDto;
import com.example.data.dto.UsersRequestDto;
import com.example.data.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;

    @PostMapping("/users")
    public List<UserResponseDto> getUsers(
            @RequestHeader Optional<String> authorization,
            @RequestBody UsersRequestDto dto
    ) {
        return usersService.findAll(dto.getUsersId());
    }

}
