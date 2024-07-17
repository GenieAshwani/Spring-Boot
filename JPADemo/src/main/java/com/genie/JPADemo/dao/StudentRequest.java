package com.genie.JPADemo.dao;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class StudentRequest {

    int id;
    String name;
    String course;
    String address;

    String DOB;

    String enrolmentNum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getEnrolmentNum() {
        return enrolmentNum;
    }

    public void setEnrolmentNum(String enrolmentNum) {
        this.enrolmentNum = enrolmentNum;
    }
}
