package com.example.techiteasynewtimes.controllers;

import com.example.techiteasynewtimes.dtos.TelevisionDto;
import com.example.techiteasynewtimes.models.Television;
import com.example.techiteasynewtimes.service.TelevisionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    @GetMapping
    public ResponseEntity<List<TelevisionDto>> getAllTelevisions(@RequestParam(value = "brand", required = false) Optional<String> brand) {

        List<TelevisionDto> dtos;

        if (brand.isEmpty()){

// We halen niet direct uit de repository een lijst met Televisions, maar we halen uit de service een lijst met TelevisionDto's
            dtos = televisionService.getAllTelevisions();

        } else {
// Dit is ook een service methode geworden in plaats van direct de repository aan te spreken.
            dtos = televisionService.getAllTelevisionsByBrand(brand.get());

        }

        return ResponseEntity.ok().body(dtos);

    }

    @PutMapping ("/{television}/{remoteController}")
    public ResponseEntity<String> addRemoteController(@PathVariable Long television, @PathVariable Long remoteController) {
        televisionService.addRemoteController(television, remoteController);
        return ResponseEntity.ok("succes");
    }


}
