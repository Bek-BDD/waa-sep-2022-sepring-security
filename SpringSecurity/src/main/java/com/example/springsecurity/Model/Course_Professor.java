package com.example.springsecurity.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course_Professor {
    @EmbeddedId
    private Course_Professor_Key course_professor_key;
    @ManyToOne
    @MapsId("courseId")
    private Course course;


    @ManyToOne
    @MapsId("professorId")
    private Professor professor;
}
