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

    private final static Logger logger=LoggerFactory.getLogger(StudentImpl.class);

    @Resource
    private StudentMapper studentMapper;
    @Override
    public int addStudent(Student student) {
        logger.info("插入信息");
        return studentMapper.insert(student);
    }

    @Override
    public Student getStudentById(int Id) {
        log.info("logback 成功了");
        log.error("logback 成功了");
        log.info(String.valueOf(Id));
        return studentMapper.selectByPrimaryKey(Id);
    }
}
