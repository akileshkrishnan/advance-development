package com.yoga.sree.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.yoga.sree.dto.request.CourseRequest;
import com.yoga.sree.dto.response.BasicResponse;
import com.yoga.sree.dto.response.CourseResponse;
import com.yoga.sree.dto.response.RegisterResponse;
import com.yoga.sree.model.Course;
import com.yoga.sree.repository.CourseRepository;
import com.yoga.sree.service.CourseService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{
    private final CourseRepository courseRepository;

    @Override
    public BasicResponse<CourseResponse> getAllcourses() {
        List<Course> courses = courseRepository.findAll();
        List<CourseResponse> courseResponses = courses.stream().map(course->CourseResponse.builder()
        .course_id(course.getCourse_id())
        .duration(course.getDuration())
        .institution(course.getInstitution())
        .course_name(course.getCourse_name())
        .build())
        .collect(Collectors.toList()); 
        return BasicResponse.<CourseResponse>builder()
        .message("Course data fetched successfully!")
          .data(courseResponses)
          .build();
    }

    @SuppressWarnings("null")
    @Override
    public RegisterResponse addCourse(CourseRequest request)
    {
        var user=Course.builder()
        .course_name(request.getCourse_name())
        .duration(request.getDuration())
        .institution(request.getInstitution())
        .build();
        courseRepository.save(user);
        return RegisterResponse.builder()
        .message("course created successfully")
        .build();
    }

    

    @Override
    public BasicResponse<CourseResponse> deletecourse(String course_id) {
        if (courseRepository.existsById(course_id)) {
            courseRepository.deleteById(course_id);
            return BasicResponse.<CourseResponse>builder()
                .message("Booking deleted successfully")
                .build();
        } else {
            return BasicResponse.<CourseResponse>builder()
                .message("Booking not found with ID: " + course_id)
                .build();
        }
    }
}
