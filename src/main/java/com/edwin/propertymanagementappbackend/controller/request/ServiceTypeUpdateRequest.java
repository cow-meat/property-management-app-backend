package com.edwin.propertymanagementappbackend.controller.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ServiceTypeUpdateRequest {

    @NotNull(message = "id not null")
    private Long id;

    @NotBlank(message = "name not empty")
    private String type;

    private String description;
}
