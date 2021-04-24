package com.edwin.propertymanagementappbackend.controller.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AnnouncementCreateRequest {

    @NotBlank(message = "标题不能为空")
    private String title;

    @NotBlank(message = "内容不能为空")
    private String context;
}
