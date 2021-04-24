package com.edwin.propertymanagementappbackend.controller;

import com.edwin.propertymanagementappbackend.controller.request.AnnouncementCreateRequest;
import com.edwin.propertymanagementappbackend.controller.request.AnnouncementUpdateRequest;
import com.edwin.propertymanagementappbackend.domain.Announcement;
import com.edwin.propertymanagementappbackend.service.AnnouncementService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Api(tags = {"公告接口"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/announcement")
@CrossOrigin("*")
public class AnnouncementController {

    private final AnnouncementService service;

    @GetMapping
    @ResponseStatus(OK)
    public List<Announcement> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public Announcement findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Announcement create(@Valid @RequestBody AnnouncementCreateRequest request) {
        return service.create(request);
    }

    @PatchMapping
    @ResponseStatus(OK)
    public Announcement update(@Valid @RequestBody AnnouncementUpdateRequest request) {
        return service.update(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public void delete(@PathVariable("id") Long id) {
        service.deleteById(id);
    }
}
