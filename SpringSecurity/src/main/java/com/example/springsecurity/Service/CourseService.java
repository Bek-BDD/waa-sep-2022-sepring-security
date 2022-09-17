package com.example.springsecurity.Service;


import com.example.springsecurity.Model.Course;

import java.util.List;

public interface CourseService {
    public List<Course> findAll();
    public Course findById(int id);
    public Course addCourse(Course student);
    public Course updateCourse(Course student);
    public void deleteCourseById(int id);
}
