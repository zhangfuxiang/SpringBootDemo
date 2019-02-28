package com.example.springBootDemo.controller;

import com.example.springBootDemo.entity.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @Auther: zhangfx
 * @Date: 2019/2/20 11:29
 * @Description: spring 框架对传入的参数进行检查
 */
@RestController
@Validated
public class ValidController {

    @PostMapping("/validPost")
    public String postArgsValid(@Valid @RequestBody User user) {
        return null;
    }

    @GetMapping("/validGet")
    public String getArgsValid(@NotBlank(message = "用户不能为空！") String username,
                               @NotBlank(message = "密码不能为空！") String password) {
        return null;
    }
}
