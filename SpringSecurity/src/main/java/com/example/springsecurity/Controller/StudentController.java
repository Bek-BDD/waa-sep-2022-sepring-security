package com.example.springsecurity.Controller;

import com.example.springsecurity.Aspect.ExecutionTime;
import com.example.springsecurity.Model.Student;
import com.example.springsecurity.Service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @ExecutionTime
    @GetMapping
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @ExecutionTime
    @GetMapping("/{id}")
    public Student findById(@PathVariable int id) {
       return studentService.findById(id);
    }

    @ExecutionTime
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @ExecutionTime
    @PutMapping
    public Student updateStudent( @RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @ExecutionTime
    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable int id) {
        studentService.deleteStudentById(id);
    }

}
