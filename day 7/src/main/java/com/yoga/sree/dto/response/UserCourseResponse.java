package com.yoga.sree.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCourseResponse{
    private String user_id;
    private String course_id;
    private String userCourse_id;
}
