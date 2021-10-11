package com.example.data.mapper;

import com.example.data.dto.UserResponseDto;
import com.example.data.entity.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PaymentMapper {
    UserResponseDto fromEntity(UserEntity entity);
    List<UserResponseDto> fromEntities(List<UserEntity> entities);
}
