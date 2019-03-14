package com.example.springBootDemo.controller;

import com.example.springBootDemo.entity.Student;
import com.example.springBootDemo.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * @Auther: zhangfx
 * @Date: 2018/12/19 14:56
 * @Description:
 */
@Controller
@Validated
@RequestMapping(value = "/user")
@Slf4j
public class StudentController {


    @Autowired
    private StudentService studentService;


    @RequestMapping(value = "/showStudent")
    @ResponseBody
    public Student showStudentInfo(HttpServletRequest request, Model model){
        int userId = Integer.parseInt(request.getParameter("id"));
        Student student = this.studentService.getStudentById(userId);
        log.info(student.toString());
        return student;
/*        User user=new User();
        user.setName("test");
        return user;*/
    }

    @RequestMapping(value = "/showAllStudent")
    @ResponseBody
    public List<Student> showAllStudentInfo(HttpServletRequest request, Model model){
        int pageNum = Integer.parseInt(request.getParameter("pageNum"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        List<Student> students = this.studentService.getAllStudent(pageNum,pageSize);
        log.info(students.toString());
        return students;
/*        User user=new User();
        user.setName("test");
        return user;*/
    }

    @PostMapping(value = "/insertStudent")
    @ResponseBody
    public int insertStudent(HttpServletRequest request,Model model,@Valid @RequestBody Student student){
/*        Student student=new Student();
        student.setId(5);
        student.setAge("66");
        student.setName("小明");
        student.setGrade("88");*/
        int result=this.studentService.addStudent(student);
        return result;
    }

}
