package com.example.jpavideoproject.repository;

import com.example.jpavideoproject.model.Subject;
import org.springframework.data.repository.CrudRepository;

public interface SubjectRepo extends CrudRepository<Subject, Long> {
}
