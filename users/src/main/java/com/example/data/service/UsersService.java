package com.example.data.service;

import com.example.data.dto.UserResponseDto;
import com.example.data.mapper.PaymentMapper;
import com.example.data.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UsersService {
    private final UserRepository userRepository;
    private final PaymentMapper mapper;

    public List<UserResponseDto> findAll(List<Long> ids) {
        return mapper.fromEntities(userRepository.findAllById(ids));
    }
}
