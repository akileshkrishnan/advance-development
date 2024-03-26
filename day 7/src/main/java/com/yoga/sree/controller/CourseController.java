package com.yoga.sree.controller;

import static com.yoga.sree.utils.MyConstant.ADDCOURSE;
import static com.yoga.sree.utils.MyConstant.COURSE;
import static com.yoga.sree.utils.MyConstant.DELETECOURSE;
import static com.yoga.sree.utils.MyConstant.UPDATECOURSE;
// import static com.yoga.sree.utils.MyConstant.USER;
import static com.yoga.sree.utils.MyConstant.USERCOURSELIST;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yoga.sree.dto.request.CourseRequest;
import com.yoga.sree.dto.response.BasicResponse;
import com.yoga.sree.dto.response.CourseResponse;
import com.yoga.sree.dto.response.RegisterResponse;
import com.yoga.sree.model.Course;
import com.yoga.sree.repository.CourseRepository;
// import com.yoga.sree.dto.response.UserResponse;
import com.yoga.sree.service.CourseService;

import lombok.RequiredArgsConstructor;

import static org.springframework.http.HttpStatus.EXPECTATION_FAILED;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping(COURSE)
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    private final CourseRepository courseRepository;
    @GetMapping(USERCOURSELIST)
    public ResponseEntity<BasicResponse<CourseResponse>> getAllUser() {
            BasicResponse<CourseResponse> response=new BasicResponse<>();
            try {
                response=courseService.getAllcourses();
                return new ResponseEntity<>(response, OK);
            } catch (Exception e) {
                response.setMessage("Something went wrong!");
                return new ResponseEntity<>(response, EXPECTATION_FAILED);
            }
        }
    @PostMapping(ADDCOURSE)
        public ResponseEntity<RegisterResponse> login(@RequestBody CourseRequest request)
        {
            RegisterResponse response=new RegisterResponse();
            try
            {
                response=courseService.addCourse(request);
                return new ResponseEntity<>(response, OK);
            }
            catch(Exception e)
            {
                response.setMessage("something went wrong!");
                return new ResponseEntity<>(response,EXPECTATION_FAILED);
            }
        }

    @PutMapping(UPDATECOURSE + "/{course_id}")
        public ResponseEntity<RegisterResponse> updateBooking(@PathVariable String course_id, @RequestBody CourseRequest courseRequest) {
        RegisterResponse response = new RegisterResponse();
        try 
        {
            // Check if the course with the given courseId exists
            Optional<Course> optionalCourse = courseRepository.findById(course_id);
            if (optionalCourse.isPresent()) {
                Course existingCourse = optionalCourse.get();
                // Update the existing course details
                existingCourse.setCourse_name(courseRequest.getCourse_name());
                existingCourse.setDuration(courseRequest.getDuration());
                existingCourse.setInstitution(courseRequest.getInstitution());
                courseRepository.save(existingCourse);
                response.setMessage("Course updated successfully");
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
            } 
            else {
                response.setMessage("Course not found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } 
        catch (Exception e) {
            response.setMessage("Something went wrong");
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(response);
        }

    
    }

    @DeleteMapping(DELETECOURSE + "/{course_id}")
    public ResponseEntity<BasicResponse<CourseResponse>> deletecourse(@PathVariable String course_id) {
        BasicResponse<CourseResponse> response = new BasicResponse<>();
        try
        {
            BasicResponse<CourseResponse> deletedBookingResponse=courseService.deletecourse(course_id);
            response.setMessage(deletedBookingResponse.getMessage());
            return new ResponseEntity<>(response,OK);
        }
        catch(Exception e)
        {
            response.setMessage("Failed to delete booking"+e.getMessage());
            return new ResponseEntity<>(response,INTERNAL_SERVER_ERROR);
        }
    }
}
