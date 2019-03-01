package com.example.springBootDemo.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Student {

    @NotNull(message="id不能为空！")
    private Integer id;

    @NotBlank(message="名字不能为空！")
    private String name;

    @NotBlank(message="年龄不能为空！")
    private String age;

    @NotBlank(message="成绩不能为空！")
    private String grade;
}