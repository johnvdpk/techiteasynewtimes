package com.example.techiteasynewtimes.service;

import com.example.techiteasynewtimes.repository.TelevisionRepository;
import org.springframework.stereotype.Service;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepos;

    public TelevisionService (TelevisionRepository televisionRepos) {
        this.televisionRepos = televisionRepos;
    }

}
