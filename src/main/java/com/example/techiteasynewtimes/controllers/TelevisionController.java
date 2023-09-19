package com.example.techiteasynewtimes.controllers;

import com.example.techiteasynewtimes.service.TelevisionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private final TelevisionService televisionService;

    public TelevisionController(TelevisionService televisionService){
        this.televisionService = televisionService;

    }


}
