package com.ljerii.springcloud.controller;

import com.ljerii.springcloud.entity.Student;
import com.ljerii.springcloud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/student/add")
    @ResponseBody
    public boolean addStudnet(Student student){
        return studentService.addStudent(student);
    }

    @RequestMapping("/student/queryStudentById/{id}")
    @ResponseBody
    public Student queryStudentById(@PathVariable("id") Integer id){
        return studentService.queryStudentById(id);
    }

    @RequestMapping("/student/queryAllStudent")
    @ResponseBody
    public List<Student> queryAllStudnet(){
        return studentService.queryAllStudent();
    }
}
