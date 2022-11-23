package com.example.jpavideoproject.repository;

import com.example.jpavideoproject.model.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepo extends CrudRepository<Teacher, Long> {
}
