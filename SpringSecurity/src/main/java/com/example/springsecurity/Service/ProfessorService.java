package com.example.springsecurity.Service;


import com.example.springsecurity.Model.Professor;

import java.util.List;

public interface ProfessorService {
    public List<Professor> findAll();
    public Professor findById(int id);
    public Professor updateProfessor(Professor professor);
    public void deleteProfessorById(int id);
}
