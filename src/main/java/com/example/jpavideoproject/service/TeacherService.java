package com.example.jpavideoproject.service;

import com.example.jpavideoproject.model.Teacher;
import com.example.jpavideoproject.repository.TeacherRepo;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
public class TeacherService implements ITeacherService{

    private TeacherRepo teacherRepo;

    public TeacherService(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    @Override
    public Set<Teacher> findAll() {
        Set<Teacher> set = new HashSet<>();
        teacherRepo.findAll().forEach(set::add);
        return set;
    }

    @Override
    public Teacher save(Teacher object) {
        teacherRepo.save(object);
        return object;
    }

    @Override
    public void delete(Teacher object) {
        teacherRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        teacherRepo.deleteById(aLong);
    }

    @Override
    public Optional<Teacher> findById(Long aLong) {
        Optional<Teacher> teacher = teacherRepo.findById(aLong);
        return teacher;
    }
}
