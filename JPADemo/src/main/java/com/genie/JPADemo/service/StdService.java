package com.genie.JPADemo.service;

import com.genie.JPADemo.dao.StudentRequest;
import com.genie.JPADemo.entity.Student;

import java.util.List;

public interface StdService {

    public List<Student> getAllStudentByCourse(String courseName);

    Student saveStdData(StudentRequest studentRequest);

    void deleteStudent(int id);

    List<Student> getAllStudent();
}
