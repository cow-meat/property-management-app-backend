package com.edwin.propertymanagementappbackend.controller;

import com.edwin.propertymanagementappbackend.controller.request.CommunityServiceCreateRequest;
import com.edwin.propertymanagementappbackend.controller.request.CommunityServiceUpdateRequest;
import com.edwin.propertymanagementappbackend.domain.CommunityService;
import com.edwin.propertymanagementappbackend.service.CommunityServiceImpl;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Api(tags = {"社区服务接口"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/community-services")
@CrossOrigin("*")
public class CommunityServiceController {

    private final CommunityServiceImpl service;

    @GetMapping
    @ResponseStatus(OK)
    public List<CommunityService> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public CommunityService findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public CommunityService create(@Valid @RequestBody CommunityServiceCreateRequest request) {
        return service.create(request);
    }

    @PatchMapping
    @ResponseStatus(OK)
    public CommunityService update(@Valid @RequestBody CommunityServiceUpdateRequest request) {
        return service.update(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(OK)
    public void delete(@PathVariable("id") Long id) {
        service.deleteById(id);
    }


    @PostMapping("/{id}/close")
    @ResponseStatus(OK)
    public CommunityService close(@PathVariable("id") Long id) {
        return service.close(id);
    }

}
