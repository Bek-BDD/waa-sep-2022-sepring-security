package com.example.springsecurity.Model;

import javax.persistence.*;

@Entity
public class Course_Student {
    @EmbeddedId
    Course_Student_Key compositeKey;

    @ManyToOne
    @MapsId("studentId")
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    private Course course;
}
