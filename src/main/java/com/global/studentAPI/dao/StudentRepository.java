package com.global.studentAPI.dao;

import com.global.studentAPI.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

// this interface to enable make CRUD operation in database

@RepositoryRestResource
public interface StudentRepository extends JpaRepository<Student, Long> {

}
