package com.example.springsecurity.Service.Impl;


import com.example.springsecurity.Model.Course;
import com.example.springsecurity.Repository.CourseRepo;
import com.example.springsecurity.Service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {
    private CourseRepo courseRepo;
    public CourseServiceImpl(CourseRepo courseRepo){
        this.courseRepo=courseRepo;
    }

    @Override
    public List<Course> findAll() {
        return(List<Course>) courseRepo.findAll();
    }

    @Override
    public Course findById(int id) {
        if(courseRepo.findById(id).isPresent()){
            return courseRepo.findById(id).get();
        }
        return null;
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public Course updateCourse(Course student) {
        return courseRepo.save(student);
    }

    @Override
    public void deleteCourseById(int id) {
         courseRepo.deleteById(id);
    }
}
