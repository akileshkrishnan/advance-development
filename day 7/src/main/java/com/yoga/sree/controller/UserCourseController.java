package com.yoga.sree.controller;

import static com.yoga.sree.utils.MyConstant.USERCOURSE;
import static com.yoga.sree.utils.MyConstant.USERCOURSELIST;
import static org.springframework.http.HttpStatus.EXPECTATION_FAILED;
import static org.springframework.http.HttpStatus.OK;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yoga.sree.dto.response.BasicResponse;
import com.yoga.sree.dto.response.UserCourseResponse;
import com.yoga.sree.service.UserCourseService;

import lombok.RequiredArgsConstructor;

@RequestMapping(USERCOURSE)
@RestController
@RequiredArgsConstructor
public class UserCourseController {
     private final UserCourseService userCourseService;
     @GetMapping(USERCOURSELIST)
     public ResponseEntity<BasicResponse<UserCourseResponse>>create()
     {
      BasicResponse<UserCourseResponse> response=new BasicResponse<>();
      try{
        response=userCourseService.getAllUserCourse();
        return new ResponseEntity<>(response, OK);
      }
      catch(Exception e)
      {
        response.setMessage("Something went wrong!");
        return new ResponseEntity<>(response, EXPECTATION_FAILED);
      }
     }
}