package com.genie.JPADemo.repo;

import com.genie.JPADemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//JP = CP+Pagination
@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

    //select * from students where course ='java';
    public List<Student> findByCourse(String course);

    @Query(value = "select * from students",nativeQuery = true)
    public List<Student> getAllStudentData();
}
