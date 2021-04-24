package com.edwin.propertymanagementappbackend.controller;


import com.edwin.propertymanagementappbackend.controller.request.*;
import com.edwin.propertymanagementappbackend.domain.Owner;
import com.edwin.propertymanagementappbackend.service.OwnerService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Api(tags = {"业主接口"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/owners")
@CrossOrigin("*")
public class OwnerController {

    private final OwnerService service;

    @GetMapping
    @ResponseStatus(OK)
    public List<Owner> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public Owner findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Owner create(@Valid @RequestBody OwnerCreateRequest request) {
        return service.create(request);
    }


    @PostMapping("/login")
    @ResponseStatus(OK)
    public Owner login(@Valid @RequestBody OwnerLoginRequest request) {
        return service.login(request);
    }

    @PatchMapping
    @ResponseStatus(OK)
    public Owner update(@Valid @RequestBody OwnerUpdateRequest request) {
        return service.update(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(OK)
    public void delete(@PathVariable("id") Long id) {
        service.deleteById(id);
    }
}
