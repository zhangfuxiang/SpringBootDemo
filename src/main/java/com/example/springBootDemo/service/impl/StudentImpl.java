package com.example.springBootDemo.service.impl;

import com.example.springBootDemo.common.utils.RedisUtil;
import com.example.springBootDemo.dao.StudentMapper;
import com.example.springBootDemo.entity.Student;
import com.example.springBootDemo.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: zhangfx
 * @Date: 2018/12/19 15:31
 * @Description:
 */
@Service(value = "studentService")
@Slf4j
public class StudentImpl implements StudentService {

    @Autowired
    private RedisUtil redisUtil;
    @Resource
    private StudentMapper studentMapper;
    @Override
    public int addStudent(Student student) {
        log.info("插入信息");
        redisUtil.set(student.getId().toString(),student.getName(),30);
        //分表
        int i=student.getId()%3;
        StringBuilder tablename=new StringBuilder("student_0");
        log.info("redis:"+redisUtil.get(student.getId().toString()).toString());
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

    @Override
    public List<Student> getAllStudent(int pageNum,int PageSize) {
        PageHelper.startPage(pageNum,PageSize);
        StringBuilder tablename=new StringBuilder("student_00");
        List<Student> studentList= studentMapper.queryAllstudent(tablename.toString());
        PageInfo<Student> studentPageInfo=new PageInfo<>(studentList);
        //查询总页数
        int countPage=studentPageInfo.getPages();
        List<Student> pageList=studentPageInfo.getList();
        log.info(pageList.toString());
        return pageList;
    }
}
