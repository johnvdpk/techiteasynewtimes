package com.example.techiteasynewtimes.service;

import com.example.techiteasynewtimes.repository.WallBracketRepository;

public class WallBracketService {

    private final WallBracketRepository wallBracketRepos;

    public WallBracketService(WallBracketRepository wallBracketRepos) {
        this.wallBracketRepos = wallBracketRepos;
    }

}
