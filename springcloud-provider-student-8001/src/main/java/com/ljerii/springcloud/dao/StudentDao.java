package com.ljerii.springcloud.dao;

import com.ljerii.springcloud.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface StudentDao {

    boolean addStudent(Student student);

    Student queryStudentById(Integer id);

    List<Student> queryAllStudent();

}
