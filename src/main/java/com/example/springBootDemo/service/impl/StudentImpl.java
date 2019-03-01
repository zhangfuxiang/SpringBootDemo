package com.example.springBootDemo.service.impl;

import com.example.springBootDemo.dao.StudentMapper;
import com.example.springBootDemo.entity.Student;
import com.example.springBootDemo.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther: zhangfx
 * @Date: 2018/12/19 15:31
 * @Description:
 */
@Service(value = "studentService")
@Slf4j
public class StudentImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;
    @Override
    public int addStudent(Student student) {
        log.info("插入信息");
        //分表
        int i=student.getId()%3;
        StringBuilder tablename=new StringBuilder("student_0");
        return studentMapper.insert(student,tablename.append(i).toString());
    }

    @Override
    public Student getStudentById(int id) {
        log.info("logback 成功了");
        log.error("logback 成功了");
        log.info(String.valueOf(id));
        //分表
        int i=id%3;
        StringBuilder tablename=new StringBuilder("student_0");
        return studentMapper.selectByPrimaryKey(id,tablename.append(i).toString());
    }
}
