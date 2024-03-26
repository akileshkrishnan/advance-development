package com.yoga.sree.service.impl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.yoga.sree.dto.response.BasicResponse;
import com.yoga.sree.dto.response.UserCourseResponse;
import com.yoga.sree.model.UserCourse;
import com.yoga.sree.repository.UserCourseRepository;
import com.yoga.sree.service.UserCourseService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserCourseServiceImpl implements UserCourseService {
     private final UserCourseRepository userCourseRepository;

    @Override
    public BasicResponse<UserCourseResponse> getAllUserCourse() {
        List<UserCourse> users=userCourseRepository.findAll();
        List<UserCourseResponse> userCourseResponses=users.stream()
        .map(user->UserCourseResponse.builder()
        // .userCourse_id(user.getUserCourse_id())
        // .course_id(user.getCourse().getCourse_id())
        // .user_id(user.getUser().getId())
        .build())
        .collect(Collectors.toList());
        return BasicResponse.<UserCourseResponse>builder()
        .message("User data fetched!")
        .data(userCourseResponses)
        .build();
    }
     
}
