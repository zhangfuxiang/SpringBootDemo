package com.example.springBootDemo.controller;

import com.example.springBootDemo.entity.Student;
import com.example.springBootDemo.service.StudentService;
import com.example.springBootDemo.service.impl.StudentImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: zhangfx
 * @Date: 2018/12/19 14:56
 * @Description:
 */
@Controller
@RequestMapping(value = "/user")
public class StudentController {

    
    private final static Logger logger=LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;


    @RequestMapping(value = "/showStudent")
    @ResponseBody
    public Student showStudentInfo(HttpServletRequest request, Model model){
        int userId = Integer.parseInt(request.getParameter("id"));
        Student student = this.studentService.getStudentById(userId);
        logger.info(student.toString());
        return student;
/*        User user=new User();
        user.setName("test");
        return user;*/
    }

    @RequestMapping(value = "/insertStudent")
    @ResponseBody
    public int insertStudent(HttpServletRequest request,Model model){
        Student student=new Student();
        student.setId(5);
        student.setAge("66");
        student.setName("小明");
        student.setGrade("88");
        int result=this.studentService.addStudent(student);
        return result;
    }

}
