package com.yoga.sree.model;

import static jakarta.persistence.GenerationType.UUID;

// import java.util.List;

// import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.OneToMany;
// import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
// @Table(name="usercourses")
public class UserCourse {
    @Id
    @GeneratedValue(strategy = UUID)
    private String userCourse_id;
    
   

    // @ManyToOne
    // @JoinColumn(name="course_id")
    // private Course course;


}
