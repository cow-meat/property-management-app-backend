package com.edwin.propertymanagementappbackend.controller.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CommunityServiceUpdateRequest {

    @NotNull(message = "工单id不能为空")
    private Long id;

    @NotNull(message = "业务id不能为空")
    private Long ownerId;

    @NotNull(message = "类型id不能为空")
    private Long typeId;

    @NotNull(message = "服务具体描述不能为空")
    private String context;
}
