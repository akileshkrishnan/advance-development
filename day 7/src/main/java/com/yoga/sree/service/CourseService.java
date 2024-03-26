package com.yoga.sree.service;

import com.yoga.sree.dto.request.CourseRequest;
import com.yoga.sree.dto.response.BasicResponse;
import com.yoga.sree.dto.response.CourseResponse;
// import com.yoga.sree.dto.response.UserResponse;
import com.yoga.sree.dto.response.RegisterResponse;

public interface CourseService {

    BasicResponse<CourseResponse> getAllcourses();

    BasicResponse<CourseResponse> deletecourse(String course_id);

    RegisterResponse addCourse(CourseRequest request);
}
