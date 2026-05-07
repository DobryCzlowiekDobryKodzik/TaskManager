package com.example.TaskManager.mappers;


import com.example.TaskManager.dtos.CreateUserRequest;
import com.example.TaskManager.dtos.UserResponse;
import com.example.TaskManager.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(CreateUserRequest createUserRequest);
    UserResponse toDto(User user);
}
