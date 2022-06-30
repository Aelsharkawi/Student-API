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


    //end point to show all students
    @GetMapping("students")
    public List<Student> getStudents() {
        return studentServices.getStudents();
    }

    //end points to student by id
    // http://localhost:8080/system/student?id=12
    @GetMapping("student")
    public Student getStudentById (@RequestParam Long id){
        return studentServices.getStudentById(id);
    }

    // end point to save student
    @PostMapping("saveSt")
    public Student saveStudent(@RequestBody Student student){
         studentServices.saveStudent(student);
         return student;
    }

    // end point to save a students list
    @PostMapping("saveStudents")
    public void saveStudents(@RequestBody List<Student> students) {
        studentServices.saveStudents(students);
    }

    //end point to delete student by id
    @DeleteMapping("deleteId")
    public void deleteByID(@RequestParam Long id) {
        studentServices.deleteById(id);
    }

    // end point to update student
    @PutMapping("update")
    public Student updateStudent(@RequestBody Student student)
    {
        studentServices.updateStudent(student);
        return student;
    }


}
