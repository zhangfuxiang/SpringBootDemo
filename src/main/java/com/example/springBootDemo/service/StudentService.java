package com.example.springBootDemo.service;

import com.example.springBootDemo.entity.Student;

/**
 * @Auther: zhangfx
 * @Date: 2018/12/19 15:29
 * @Description:
 */
public interface StudentService {
    int addStudent(Student student);

    Student getStudentById(int Id);
}
