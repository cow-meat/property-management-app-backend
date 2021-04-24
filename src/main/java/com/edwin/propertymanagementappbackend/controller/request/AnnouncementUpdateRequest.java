package com.edwin.propertymanagementappbackend.controller.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AnnouncementUpdateRequest {

    @NotNull(message = "id 不能为空")
    private Long id;

    @NotBlank(message = "标题不能为空")
    private String title;

    @NotBlank(message = "内容不能为空")
    private String context;
}
