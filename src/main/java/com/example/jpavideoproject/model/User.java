package com.example.jpavideoproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;

    @JsonBackReference
    @ManyToMany(mappedBy = "enrolledUsers")
    private Set<Subject> subjects = new HashSet<>();

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
