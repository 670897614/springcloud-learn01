package com.ljerii.springcloud.controller;

import com.ljerii.springcloud.entity.Student;
import com.ljerii.springcloud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    //获取配置信息，得到具体的微服务
    @Autowired
    private DiscoveryClient client;

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

    //获取注册进来的微服务信息
    @RequestMapping("/student/discovery")
    @ResponseBody
    public Object discovery(){
        //获取微服务清单
        List<String> services = client.getServices();
        System.out.println(services);

        //获取具体微服务,通过具体微服务id（application.name）
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-STUDENT");

        for (ServiceInstance instance:instances)
            System.out.println(instance);

        return client;
    }
}
