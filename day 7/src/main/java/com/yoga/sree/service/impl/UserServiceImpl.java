package com.yoga.sree.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.yoga.sree.dto.response.BasicResponse;
import com.yoga.sree.dto.response.UserResponse;
import com.yoga.sree.model.User;
import com.yoga.sree.repository.UserRepository;
import com.yoga.sree.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    @Override
    public BasicResponse<UserResponse> getAlluser() 
    {                       
        List<User> users = userRepository.findAll();
        List<UserResponse> userResponses = users.stream()
            .map(user -> UserResponse.builder()
            .id(user.getId())
            .name(user.getName())
            .email(user.getEmail())
            .role(user.getRole())
            .image(user.getImage())
            // .mobile(user.getMobile()) 
            .build())
            .collect(Collectors.toList());
            return BasicResponse.<UserResponse>builder()
                .message("user data fetched successfully!")
                .data(userResponses)
                .build();
    }

}
