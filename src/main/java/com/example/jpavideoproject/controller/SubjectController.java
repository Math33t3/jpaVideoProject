package com.example.jpavideoproject.controller;



import com.example.jpavideoproject.model.Subject;
import com.example.jpavideoproject.model.Teacher;
import com.example.jpavideoproject.model.User;
import com.example.jpavideoproject.service.SubjectService;
import com.example.jpavideoproject.service.TeacherService;
import com.example.jpavideoproject.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
@RestController
public class SubjectController {
    private SubjectService subjectService;
    private UserService userService;
    private TeacherService teacherService;

    public SubjectController(SubjectService subjectService, UserService userService, TeacherService teacherService) {
        this.subjectService = subjectService;
        this.userService = userService;
        this.teacherService = teacherService;
    }

    @PostMapping("/createSubject")
    public ResponseEntity<Subject> createSubject(@ModelAttribute Subject subject){
        System.out.println("received subject " + subject.getId() + " " + subject.getName());
        subjectService.save(subject);
        return new ResponseEntity<>(subject, HttpStatus.OK);
    }

    @GetMapping("/getSubjects")
    public ResponseEntity<Set<Subject>> getSubjects(){
        return new ResponseEntity<>(subjectService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/addUserToSubject")
    public ResponseEntity<Subject> addUserToSubject(
            @RequestParam Long subjectId, @RequestParam Long userId){
        Subject subject = subjectService.findById(subjectId).get();
        User user = userService.findById(userId).get();
        subject.addUser(user);
        subjectService.save(subject);
        return new ResponseEntity<>(subject, HttpStatus.OK);
    }

    @PostMapping("/addTeacherToSubject")
    public ResponseEntity<Subject> addTeacherToSubject(
            @RequestParam Long subjectId, @RequestParam Long teacherId){
        Subject subject = subjectService.findById(subjectId).get();
        Teacher teacher = teacherService.findById(teacherId).get();
        subject.setTeacher(teacher);
        subjectService.save(subject);
        return new ResponseEntity<>(subject, HttpStatus.OK);
    }

   /* //den gamle der virker med @PathVariable men kun i postman
    @PutMapping("/{subjectId}/Users/{userId}")
    public ResponseEntity<Subject> addUserToSubject(
            @PathVariable Long subjectId, @PathVariable Long userId){
        Subject subject = subjectService.findById(subjectId).get();
        User user = userService.findById(userId).get();
        subject.addUser(user);
        return new ResponseEntity<>(subjectService.save(subject), HttpStatus.OK);

    }*/

}
