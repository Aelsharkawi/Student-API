package com.global.studentAPI.dao;

import com.global.studentAPI.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface StudentRepository extends JpaRepository<Student, Long> {

//    @Modifying
//    @Query("update s set full_name = s.name, age = s.age, " +
//            "address= s.address, phone_number=s.phone where id =id")
//    public List<Student> update (Long id);
}
