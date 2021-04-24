package com.edwin.propertymanagementappbackend.controller;

import com.edwin.propertymanagementappbackend.controller.request.AnnouncementCreateRequest;
import com.edwin.propertymanagementappbackend.controller.request.AnnouncementUpdateRequest;
import com.edwin.propertymanagementappbackend.domain.Announcement;
import com.edwin.propertymanagementappbackend.service.AnnouncementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Api(tags = {"公告接口"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/announcements")
@CrossOrigin("*")
public class AnnouncementController {

    private final AnnouncementService service;

    @ApiOperation(value = "获取所有的 公告")
    @GetMapping
    @ResponseStatus(OK)
    public List<Announcement> getAll() {
        return service.getAll();
    }

    @ApiOperation(value = "通过id获取公告")
    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public Announcement findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @ApiOperation(value = "新增公告")
    @PostMapping
    @ResponseStatus(CREATED)
    public Announcement create(@Valid @RequestBody AnnouncementCreateRequest request) {
        return service.create(request);
    }

    @ApiOperation(value = "更新公告")
    @PatchMapping
    @ResponseStatus(OK)
    public Announcement update(@Valid @RequestBody AnnouncementUpdateRequest request) {
        return service.update(request);
    }

    @ApiOperation(value = "通过id删除公告")
    @DeleteMapping("/{id}")
    @ResponseStatus(OK)
    public void delete(@PathVariable("id") Long id) {
        service.deleteById(id);
    }
}
