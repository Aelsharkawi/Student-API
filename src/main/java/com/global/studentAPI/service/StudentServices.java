package com.global.studentAPI.service;

import com.global.studentAPI.dao.StudentRepository;
import com.global.studentAPI.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServices {

    private StudentRepository studentRepository;
    @Autowired
    public StudentServices(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents()
    {
        return studentRepository.findAll();
    }
    public Student getStudentById (Long id){
        return studentRepository.findById(id).get();
    }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }
    public void saveStudents(List<Student> students) {
        studentRepository.saveAll(students);
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    public void updateStudent(Student student) {
        studentRepository.save(student);
    }
}
