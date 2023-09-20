package com.example.techiteasynewtimes.service;

import com.example.techiteasynewtimes.models.CIModule;
import com.example.techiteasynewtimes.repository.CIModuleRepository;
import org.springframework.stereotype.Service;

@Service
public class CIModuleService {

    private final CIModuleRepository cIModuleRepos;

    public CIModuleService (CIModuleRepository cIModuleRepos) {
        this.cIModuleRepos = cIModuleRepos;
    }



}
