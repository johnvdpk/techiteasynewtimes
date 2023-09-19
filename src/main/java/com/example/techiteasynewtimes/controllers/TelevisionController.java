package com.example.techiteasynewtimes.controllers;

import com.example.techiteasynewtimes.dtos.TelevisionDto;
import com.example.techiteasynewtimes.models.Television;
import com.example.techiteasynewtimes.service.TelevisionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private final TelevisionService televisionService;

    public TelevisionController(TelevisionService televisionService){
        this.televisionService = televisionService;

    }

    @PostMapping
    public ResponseEntity<TelevisionDto> createTelevision (@RequestBody TelevisionDto televisionDto) {
        Television television = new Television();

        return new ResponseEntity<>(televisionDto, HttpStatus.CREATED);

    }
}
