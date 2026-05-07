package com.example.TaskManager.services;

import com.example.TaskManager.dtos.CreateUserRequest;
import com.example.TaskManager.dtos.UserResponse;
import com.example.TaskManager.entities.User;
import com.example.TaskManager.mappers.UserMapper;
import com.example.TaskManager.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    //@PreAuthorize("hasRole('ADMIN')")
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(users -> new UserResponse(users.getId(),users.getUsername(),users.getRole()))
                .toList();
    }
    public UserResponse createUser(CreateUserRequest userRequest) {
        var user = userMapper.toEntity(userRequest);
        UserResponse userResponse = userMapper.toDto(user);
        userRepository.save(user);
        return userResponse;

    }
}
