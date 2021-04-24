package com.edwin.propertymanagementappbackend.controller.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ServiceTypeCreateRequest {

    @NotBlank(message = "name not empty")
    private String type;

    private String description;
}
