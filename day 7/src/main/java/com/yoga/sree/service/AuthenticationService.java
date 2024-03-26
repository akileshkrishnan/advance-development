package com.yoga.sree.service;

import com.yoga.sree.dto.request.LoginRequest;
import com.yoga.sree.dto.request.RegisterRequest;
import com.yoga.sree.dto.response.LoginResponse;
import com.yoga.sree.dto.response.RegisterResponse;

public interface AuthenticationService {

    RegisterResponse register(RegisterRequest request);
    
    LoginResponse login(LoginRequest request);
    
}
