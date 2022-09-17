package com.example.springsecurity.Service;

import com.example.springsecurity.Model.Student;

import java.util.List;

public interface StudentService {
    public List<Student> findAll();
    public Student findById(int id);
    public Student addStudent(Student student);
    public Student updateStudent(Student student);
    public void deleteStudentById(int id);
}
