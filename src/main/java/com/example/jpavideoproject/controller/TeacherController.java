package com.example.jpavideoproject.controller;

import com.example.jpavideoproject.model.Subject;
import com.example.jpavideoproject.model.Teacher;
import com.example.jpavideoproject.model.User;
import com.example.jpavideoproject.service.SubjectService;
import com.example.jpavideoproject.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class TeacherController {

    private SubjectService subjectService;
    private TeacherService teacherService;

    public TeacherController(SubjectService subjectService, TeacherService teacherService) {
        this.subjectService = subjectService;
        this.teacherService = teacherService;
    }

    @PostMapping("/createTeacher")
    public ResponseEntity<Teacher> createTeacher(@ModelAttribute Teacher teacher){
        System.out.println("received subject " + teacher.getId() + " " + teacher.getName());
        teacherService.save(teacher);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    @GetMapping("/getTeachers")
    public ResponseEntity<Set<Teacher>> getTeachers(){
        return new ResponseEntity<>(teacherService.findAll(), HttpStatus.OK);
    }


}
