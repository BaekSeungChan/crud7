package com.qortmdcks95.curd7.controller;

import com.qortmdcks95.curd7.payload.ChildDto;
import com.qortmdcks95.curd7.service.ChildService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/child")
public class ChildController {
    private ChildService childService;

    public ChildController(ChildService childService){
        this.childService = childService;
    }

    @PostMapping
    public ResponseEntity<ChildDto> createChild(@Valid @RequestBody ChildDto childDto){
        return new ResponseEntity<>(childService.createChild(childDto), HttpStatus.OK);
    }
}
