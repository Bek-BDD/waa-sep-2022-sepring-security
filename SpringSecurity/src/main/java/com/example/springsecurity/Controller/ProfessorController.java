package com.example.springsecurity.Controller;


import com.example.springsecurity.Aspect.ExecutionTime;
import com.example.springsecurity.Model.Professor;
import com.example.springsecurity.Service.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professors")
public class ProfessorController {
    private ProfessorService professorService;
    public ProfessorController(ProfessorService professorService){
        this.professorService=professorService;
    }
    @ExecutionTime
    @GetMapping
    public List<Professor> findAll() {
        return professorService.findAll();
    }
    @ExecutionTime
    @GetMapping("/{id}")
    public Professor findById(@PathVariable int id) {
        return professorService.findById(id);
    }

    @ExecutionTime
    @PostMapping
    public Professor addProfessor(@RequestBody Professor professor) {
        return professorService.addProfessor(professor);
    }

    @ExecutionTime
    @PutMapping
    public Professor updateProfessor(@RequestBody Professor professor) {
        return professorService.updateProfessor(professor);
    }

    @ExecutionTime
    @DeleteMapping("/{id}")
    public void deleteProfessorById(@PathVariable int id) {
        professorService.deleteProfessorById(id);
    }
}
