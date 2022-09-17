package com.example.springsecurity.Model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class Professor_Student {
    @EmbeddedId
    private Professor_Student_Key professor_student_key;
    @ManyToOne
    @MapsId("ProfessorId")
    private Professor professor;

    @ManyToOne
    @MapsId("StudentId")
    private Student student;

}
