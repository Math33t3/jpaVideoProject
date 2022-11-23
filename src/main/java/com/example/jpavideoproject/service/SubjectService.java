package com.example.jpavideoproject.service;

import com.example.jpavideoproject.model.Subject;
import com.example.jpavideoproject.model.User;
import com.example.jpavideoproject.repository.SubjectRepo;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class SubjectService implements ISubjectService {

    private SubjectRepo subjectRepo;

    public SubjectService(SubjectRepo subjectRepo) {
        this.subjectRepo = subjectRepo;
    }

    @Override
    public Set<Subject> findAll() {
        Set<Subject> set = new HashSet<>();
        subjectRepo.findAll().forEach(set::add);
        return set;
    }

    @Override
    public Subject save(Subject object) {
        subjectRepo.save(object);
        return object;
    }

    @Override
    public void delete(Subject object) {
        subjectRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        subjectRepo.deleteById(aLong);
    }

    @Override
    public Optional<Subject> findById(Long aLong) {
        Optional<Subject> subject = subjectRepo.findById(aLong);
        return subject;
    }
}
