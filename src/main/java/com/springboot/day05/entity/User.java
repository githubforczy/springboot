package com.springboot.day05.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @NotEmpty(message = "姓名不能为空")
    private String name;
    @NotNull(message = "年龄不能为空")
    @Max(value = 85,message = "请专心养老！")
    @Min(value = 16,message = "16禁")
    private int age;
    @NotEmpty(message = "密码不能为空")
    private String pass;
}
