package com.example.techiteasynewtimes.controllers;

import com.example.techiteasynewtimes.service.CIModuleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name="/ci_modules")
public class CIModuleController {

    private final CIModuleService cIModuleService;

    public CIModuleController (CIModuleService cIModuleService){
        this.cIModuleService = cIModuleService;
    }
}
