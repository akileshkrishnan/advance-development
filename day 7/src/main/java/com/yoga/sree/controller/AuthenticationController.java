package com.yoga.sree.controller;

import static com.yoga.sree.utils.MyConstant.AUTH;
import static com.yoga.sree.utils.MyConstant.LOGIN;
import static com.yoga.sree.utils.MyConstant.REGISTER;
import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.EXPECTATION_FAILED;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yoga.sree.dto.request.LoginRequest;
import com.yoga.sree.dto.request.RegisterRequest;
import com.yoga.sree.dto.response.LoginResponse;
import com.yoga.sree.dto.response.RegisterResponse;
import com.yoga.sree.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(AUTH)
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping(REGISTER)
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request)
    {
        System.out.println(request);
        RegisterResponse response=new RegisterResponse();
        try {
            response=authenticationService.register(request);
            return new ResponseEntity<>(response,ACCEPTED);
        } catch (Exception e) {
            System.out.print(e);
            response.setMessage("Something went wrong");
            return new ResponseEntity<>(response, EXPECTATION_FAILED);
        }
    }
    @PostMapping(LOGIN)
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request)
    {
        LoginResponse response = new LoginResponse();
        try {
            response=authenticationService.login(request);
            return new ResponseEntity<>(response,ACCEPTED);
        } catch (Exception e) {
            System.out.println(e);
            response.setMessage("Something went wrong!");
            response.setToken("");
            return new ResponseEntity<>(response,EXPECTATION_FAILED);
        }
    }
}
