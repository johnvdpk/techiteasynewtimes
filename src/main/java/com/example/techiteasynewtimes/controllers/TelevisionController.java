package com.example.techiteasynewtimes.controllers;

import com.example.techiteasynewtimes.dtos.TelevisionDto;
import com.example.techiteasynewtimes.dtos.TelevisionInputDto;
import com.example.techiteasynewtimes.models.Television;
import com.example.techiteasynewtimes.service.TelevisionService;
import jakarta.validation.Valid;
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

    @GetMapping
    public ResponseEntity<List<TelevisionDto>> getAllTelevisions(@RequestParam(value = "brand", required = false) Optional<String> brand) {

        List<TelevisionDto> televisionDtos;

        if (brand.isEmpty()){

            // We halen niet direct uit de repository een lijst met Televisions, maar we halen uit de service een lijst met TelevisionDto's
            televisionDtos = televisionService.getAllTelevisions();

        } else {
            // Dit is ook een service methode geworden in plaats van direct de repository aan te spreken.
            televisionDtos = televisionService.getAllTelevisionsByBrand(brand.get());

        }

        return ResponseEntity.ok().body(televisionDtos);

    }


    @GetMapping("/{id}")
    public ResponseEntity<TelevisionDto> getTelevisionById(@PathVariable Long id) {
        TelevisionDto televisionDto = televisionService.getTelevisionById(id);

        if (televisionDto != null) {
            return ResponseEntity.ok(televisionDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity<TelevisionDto> addTelevision(@Valid @RequestBody TelevisionInputDto televisionInputDto) {

        TelevisionDto televisionDto = televisionService.addTelevision(televisionInputDto);

        return ResponseEntity.created(null).body(televisionDto);
    }

//    @PostMapping
//    public ResponseEntity<TelevisionDto> createTelevision (@RequestBody TelevisionDto televisionDto) {
//        Television television = new Television();
//
//        return new ResponseEntity<>(televisionDto, HttpStatus.CREATED);
//
//    }



    @PutMapping ("/{television}/{remoteController}")
    public ResponseEntity<String> addRemoteController(@PathVariable Long television, @PathVariable Long remoteController) {
        televisionService.addRemoteController(television, remoteController);
        return ResponseEntity.ok("succes");
    }



}
