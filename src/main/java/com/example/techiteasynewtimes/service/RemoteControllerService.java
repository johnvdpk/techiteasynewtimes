package com.example.techiteasynewtimes.service;

import com.example.techiteasynewtimes.repository.RemoteControllerRepository;
import org.springframework.stereotype.Service;

@Service
public class RemoteControllerService {

    private final RemoteControllerRepository remoteControllerRepos;

    public RemoteControllerService (RemoteControllerRepository remoteControllerRepos) {
        this.remoteControllerRepos = remoteControllerRepos;
    }



}
