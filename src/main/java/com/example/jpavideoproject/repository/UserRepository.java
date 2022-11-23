package com.example.jpavideoproject.repository;

import com.example.jpavideoproject.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
