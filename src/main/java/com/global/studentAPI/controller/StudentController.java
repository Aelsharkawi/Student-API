package com.global.studentAPI.controller;

import com.global.studentAPI.dao.StudentRepository;
import com.global.studentAPI.entity.Student;
import com.global.studentAPI.service.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("system")
public class StudentController {

    private StudentServices studentServices;
    @Autowired
    public StudentController(StudentServices studentServices) {
        this.studentServices = studentServices;
    }

    @GetMapping("students")
    public List<Student> getStudents() {
        return studentServices.getStudents();
    }

    // http://localhost:8080/system/student?id=12
    @GetMapping("student")
    public Student getStudentById (@RequestParam Long id){
        return studentServices.getStudentById(id);
    }

    @PostMapping("saveSt")
    public void saveStudent(@RequestBody Student student){
         studentServices.saveStudent(student);
    }

    @PostMapping("saveStudents")
    public void saveStudents(@RequestBody List<Student> students) {
        studentServices.saveStudents(students);
    }
    @DeleteMapping("{deleteId}")
    public void deleteByID(@PathVariable("deleteId") Long id) {
        studentServices.deleteById(id);
    }

    @PutMapping
    public Student updateStudent(@RequestBody Student student)
    {
        studentServices.updateStudent(student);
        return student;
    }

}
