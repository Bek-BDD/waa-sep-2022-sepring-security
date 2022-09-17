package com.example.springsecurity.Service.Impl;

import com.example.springsecurity.Model.Professor;
import com.example.springsecurity.Repository.ProfessorRepo;
import com.example.springsecurity.Service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProfessorServiceImpl implements ProfessorService {

    private ProfessorRepo professorRepo;

    public ProfessorServiceImpl(ProfessorRepo professorRepo){
        this.professorRepo=professorRepo;
    }

    @Override
    public List<Professor> findAll() {
        return (List<Professor>) professorRepo.findAll();
    }

    @Override
    public Professor findById(int id) {
       if(professorRepo.findById(id).isPresent()){
           professorRepo.findById(id);
       }
       return null;
    }



    @Override
    public Professor updateProfessor(Professor professor) {
        BCryptPasswordEncoder encrypted  = new BCryptPasswordEncoder();
        String encrypted_password=encrypted.encode(professor.getPassword());
        professor.setPassword(encrypted_password);
        return professorRepo.save(professor);
    }

    @Override
    public void deleteProfessorById(int id) {
         professorRepo.deleteById(id);
    }
}
