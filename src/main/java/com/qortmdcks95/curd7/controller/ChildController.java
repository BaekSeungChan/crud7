package com.qortmdcks95.curd7.controller;

import com.qortmdcks95.curd7.entity.Child;
import com.qortmdcks95.curd7.payload.ChildDto;
import com.qortmdcks95.curd7.service.ChildService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PatchExchange;

import java.util.List;

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

    @GetMapping("/all")
    public ResponseEntity<List<ChildDto>> getAllChild(){
        return ResponseEntity.ok(childService.getAllChild());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChildDto> getChildById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(childService.getChildById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChildById(@PathVariable(name = "id") long id){
        childService.deleteChildById(id);
        return ResponseEntity.ok("delete child");
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChildDto> updateChild(@PathVariable(name = "id") long id, @Valid @RequestBody ChildDto childDto){
        ChildDto childReponse = childService.updateChild(childDto, id);
        return new ResponseEntity<>(childReponse, HttpStatus.OK);
    }

}
