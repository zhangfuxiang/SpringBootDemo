package com.example.springBootDemo.entity;

import lombok.Data;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Auther: zhangfx
 * @Date: 2019/2/20 11:31
 * @Description:
 */
@Data
public class User {

    @NotBlank(message="用户名不能为空！")
    String username;

    @NotBlank(message="密码不能为空！")
    String password;
}
