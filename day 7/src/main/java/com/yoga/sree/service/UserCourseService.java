package com.yoga.sree.service;

import com.yoga.sree.dto.response.BasicResponse;
import com.yoga.sree.dto.response.UserCourseResponse;

public interface UserCourseService {
    BasicResponse<UserCourseResponse> getAllUserCourse();

}
