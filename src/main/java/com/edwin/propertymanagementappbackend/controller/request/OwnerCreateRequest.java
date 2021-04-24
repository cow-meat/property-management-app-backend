package com.edwin.propertymanagementappbackend.controller.request;

import com.edwin.propertymanagementappbackend.enums.Gender;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class OwnerCreateRequest {
    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String pwd;

    @NotNull(message = "性别不能为空")
    private Gender gender;

    @NotBlank(message = "姓名不能为空")
    private String name;

    @NotBlank(message = "单元不能为空")
    private String unit;

    @NotBlank(message = "楼层不能为空")
    private String floor;

    @NotBlank(message = "门牌号不能为空")
    private String homeNum;

    @NotBlank(message = "联系方式不嗯为空")
    private String phone;
}
