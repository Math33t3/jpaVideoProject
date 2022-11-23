package com.example.jpavideoproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;

    //en lærer skal kunne undervise i flere emner, men et emne skal kun have en underviser
    @JsonBackReference
    @OneToMany(mappedBy = "teacher")
    private Set<Subject> taughtSubjects= new HashSet<>();

}
