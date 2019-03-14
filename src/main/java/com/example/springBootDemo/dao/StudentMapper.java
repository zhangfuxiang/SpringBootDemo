package com.example.springBootDemo.dao;

import com.example.springBootDemo.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(@Param("student") Student student,@Param("tablename") String tablename);

    int insertSelective(Student record);

    Student selectByPrimaryKey(@Param("id")Integer id,@Param("tablename") String tablename);

    List<Student> queryAllstudent(@Param("tablename") String tablename);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}