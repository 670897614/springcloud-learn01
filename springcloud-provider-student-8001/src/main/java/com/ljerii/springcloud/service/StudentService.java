package com.ljerii.springcloud.service;

import com.ljerii.springcloud.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {

    boolean addStudent(Student student);

    Student queryStudentById(Integer id);

    List<Student> queryAllStudent();
}
