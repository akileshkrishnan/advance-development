package com.yoga.sree.service;

import com.yoga.sree.dto.response.BasicResponse;
import com.yoga.sree.dto.response.UserResponse;


public interface UserService {

    BasicResponse<UserResponse> getAlluser();

}
