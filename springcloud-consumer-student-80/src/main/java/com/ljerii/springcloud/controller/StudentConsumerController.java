package com.ljerii.springcloud.controller;

import com.ljerii.springcloud.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class StudentConsumerController {

    /**
     * 消费者不应有service层
     * RestTemplate(url,实体：Map,Class<T> responseType)
     * **/
    @Autowired
    private RestTemplate restTemplate;

    private static final String urlPrefix="http://localhost:8001";

    @RequestMapping("/consumer/student/add")
    @ResponseBody
    public boolean addStudent(Student student){
        return restTemplate.postForObject(urlPrefix+"/student/add",student,Boolean.class);
    }

    @RequestMapping("consumer/student/queryStudentById/{id}")
    @ResponseBody
    public Student queryStudentById(@PathVariable("id") Integer id){
        return restTemplate.getForObject(urlPrefix+"/student/queryStudentById/"+id,Student.class);
    }

    @RequestMapping("consumer/student/queryAllStudent")
    @ResponseBody
    public List<Student> queryAllStudent(){
        return restTemplate.getForObject(urlPrefix+"/student/queryAllStudent",List.class);
    }
}
