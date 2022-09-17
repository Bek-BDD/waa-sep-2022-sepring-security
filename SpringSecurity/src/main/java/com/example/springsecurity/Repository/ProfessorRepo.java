package com.example.springsecurity.Repository;


import com.example.springsecurity.Model.Professor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepo extends CrudRepository<Professor,Integer> {
}
