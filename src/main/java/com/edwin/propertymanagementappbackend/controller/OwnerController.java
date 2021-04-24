package com.edwin.propertymanagementappbackend.controller;


import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"业务接口"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/owners")
@CrossOrigin("*")
public class OwnerController {

}
