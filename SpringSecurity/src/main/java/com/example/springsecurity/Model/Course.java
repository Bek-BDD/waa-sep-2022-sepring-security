package com.example.springsecurity.Model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    private String name;
    private int credit;

    @OneToMany(mappedBy = "course")
   List<Course_Student> courseStudents;

    @OneToMany(mappedBy = "course")
    List<Course_Professor> course_professors;
}
