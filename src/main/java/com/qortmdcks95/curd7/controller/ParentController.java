package com.qortmdcks95.curd7.controller;

import com.qortmdcks95.curd7.payload.ParentDto;
import com.qortmdcks95.curd7.repository.ParentRepository;
import com.qortmdcks95.curd7.service.ParentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parent")
public class ParentController {
    private final ParentService parentService;

    public ParentController(ParentService parentService){
        this.parentService = parentService;
    }

    @PostMapping
    public ResponseEntity<ParentDto> createParent(@Valid @RequestBody ParentDto parentDto){
        return new ResponseEntity<>(parentService.createParent(parentDto), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ParentDto>> getAllParent(){
        return ResponseEntity.ok(parentService.getAllParent());
    }

}
