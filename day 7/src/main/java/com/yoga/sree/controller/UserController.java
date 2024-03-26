package com.yoga.sree.controller;

import static com.yoga.sree.utils.MyConstant.USER;
import static com.yoga.sree.utils.MyConstant.USERLIST;
import static org.springframework.http.HttpStatus.EXPECTATION_FAILED;
import static org.springframework.http.HttpStatus.OK;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yoga.sree.dto.response.BasicResponse;
import com.yoga.sree.dto.response.UserResponse;
import com.yoga.sree.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(USER)
@RequiredArgsConstructor
public class UserController {
    
    private final UserService userService;
        
    @GetMapping(USERLIST)
        public ResponseEntity<BasicResponse<UserResponse>> create() {
            BasicResponse<UserResponse> response=new BasicResponse<>();
            try {
                response=userService.getAlluser();
                return new ResponseEntity<>(response, OK);
            } catch (Exception e) {
                response.setMessage("Something went wrong!");
                return new ResponseEntity<>(response, EXPECTATION_FAILED);
            }
        }
    
}
