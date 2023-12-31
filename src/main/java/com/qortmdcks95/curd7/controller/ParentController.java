package com.qortmdcks95.curd7.controller;

import com.qortmdcks95.curd7.payload.ParentDto;
import com.qortmdcks95.curd7.repository.ParentRepository;
import com.qortmdcks95.curd7.service.ParentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parent")
@Tag(name = "Parent API's")
public class ParentController {
    private final ParentService parentService;

    public ParentController(ParentService parentService){
        this.parentService = parentService;
    }

    @PostMapping
    @Operation(
            summary = "Create parent",
            description = "Create Child API"
    )
    public ResponseEntity<ParentDto> createParent(@Valid @RequestBody ParentDto parentDto){
        return new ResponseEntity<>(parentService.createParent(parentDto), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ParentDto>> getAllParent(){
        return ResponseEntity.ok(parentService.getAllParent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParentDto> getParentById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(parentService.getParentById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteParentById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok("deleted post");
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParentDto> updateParent(@PathVariable(name = "id") long id, @Valid @RequestBody ParentDto parentDto){
        ParentDto parentResponse = parentService.updateParent(parentDto, id);
        return new ResponseEntity<>(parentResponse, HttpStatus.OK);
    }

}
