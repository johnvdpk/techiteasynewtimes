package com.example.techiteasynewtimes.controllers;

import com.example.techiteasynewtimes.repository.WallBracketRepository;
import com.example.techiteasynewtimes.service.RemoteControllerService;
import com.example.techiteasynewtimes.service.WallBracketService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name="wall_brackets")
public class WallBracketController {

    private final WallBracketService wallBracketService;

    public WallBracketController(WallBracketService wallBracketService) {
        this.wallBracketService = wallBracketService;
    }
}
