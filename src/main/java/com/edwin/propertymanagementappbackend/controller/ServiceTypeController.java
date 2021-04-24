package com.edwin.propertymanagementappbackend.controller;

import com.edwin.propertymanagementappbackend.controller.request.ServiceTypeCreateRequest;
import com.edwin.propertymanagementappbackend.controller.request.ServiceTypeUpdateRequest;
import com.edwin.propertymanagementappbackend.domain.ServiceType;
import com.edwin.propertymanagementappbackend.service.ServiceTypeService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Api(tags = {"服务类型接口"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/service-types")
@CrossOrigin("*")
public class ServiceTypeController {

    private final ServiceTypeService service;

    @GetMapping
    @ResponseStatus(OK)
    public List<ServiceType> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public ServiceType findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ServiceType create(@Valid @RequestBody ServiceTypeCreateRequest request) {
        return service.create(request);
    }

    @PatchMapping
    @ResponseStatus(OK)
    public ServiceType update(@Valid @RequestBody ServiceTypeUpdateRequest request) {
        return service.update(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(OK)
    public void delete(@PathVariable("id") Long id) {
        service.deleteById(id);
    }
}
