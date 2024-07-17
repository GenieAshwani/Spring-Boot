package com.genie.JPADemo.controller;

import com.genie.JPADemo.dao.StudentRequest;
import com.genie.JPADemo.entity.Student;
import com.genie.JPADemo.repo.StudentRepo;
import com.genie.JPADemo.service.StdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/std")
public class StudentController {

    @Autowired
    StdService stdService;

    @GetMapping("/get/{courseName}")
    public List<Student> getStudentByCourse(@PathVariable String courseName)
    {
        List<Student> allStudentByCourse = stdService.getAllStudentByCourse(courseName);
        return allStudentByCourse;
    }

    @PostMapping("/save")
    public Student saveStudent(@RequestBody StudentRequest studentRequest)
    {
        return stdService.saveStdData(studentRequest);
    }

    @DeleteMapping("delete/{id}")
    public void deleteStudent(@PathVariable int id)
    {
        stdService.deleteStudent(id);
    }

    @GetMapping("/get")
    public List<Student> getAllStudent()
    {
        List<Student> allStudent = stdService.getAllStudent();
        return allStudent;
    }

}
