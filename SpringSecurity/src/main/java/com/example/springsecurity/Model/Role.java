package com.example.springsecurity.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<AppUser> persons;


}
