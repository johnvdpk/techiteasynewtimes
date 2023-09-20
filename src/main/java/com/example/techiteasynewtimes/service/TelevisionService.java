package com.example.techiteasynewtimes.service;

import com.example.techiteasynewtimes.controllers.TelevisionController;
import com.example.techiteasynewtimes.dtos.TelevisionDto;
import com.example.techiteasynewtimes.models.RemoteController;
import com.example.techiteasynewtimes.models.Television;
import com.example.techiteasynewtimes.repository.RemoteControllerRepository;
import com.example.techiteasynewtimes.repository.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepos;
    private final RemoteControllerRepository remoteControllerRepos;

    public TelevisionService(TelevisionRepository televisionRepos, RemoteControllerRepository remoteControllerRepos) {
        this.televisionRepos = televisionRepos;
        this.remoteControllerRepos = remoteControllerRepos;
    }

    public TelevisionDto createTelevision(TelevisionDto televisionDto) {
        Television television = new Television();

        television.setId(televisionDto.id);
        television.setType(televisionDto.type);
        television.setBrand(televisionDto.brand);
        television.setName(televisionDto.name);
        television.setPrice(televisionDto.price);
        television.setAvailableSize(televisionDto.availableSize);
        television.setRefreshRate(televisionDto.refreshRate);
        television.setScreenType(televisionDto.screenType);
        television.setScreenQuality(televisionDto.screenQuality);
        television.setSmartTv(televisionDto.smartTv);
        television.setWifi(televisionDto.wifi);
        television.setVoiceControl(televisionDto.voiceControl);
        television.setHdr(televisionDto.hdr);
        television.setBluetooth(televisionDto.bluetooth);
        television.setAmbiLight(televisionDto.ambiLight);
        television.setOriginalStock(televisionDto.originalStock);
        television.setSold(televisionDto.sold);
        television = televisionRepos.save(television);

        return televisionDto;


    }

    public TelevisionDto transferToDto(Television television) {
        TelevisionDto televisionDto = new TelevisionDto();

        televisionDto.setId(television.getId());
        televisionDto.setType(television.getType());
        televisionDto.setBrand(television.getBrand());
        televisionDto.setName(television.getName());
        televisionDto.setPrice(television.getPrice());
        televisionDto.setAvailableSize(television.getAvailableSize());
        televisionDto.setRefreshRate(television.getRefreshRate());
        televisionDto.setScreenType(television.getScreenType());
        televisionDto.setScreenQuality(television.getScreenQuality());
        televisionDto.setSmartTv(television.getWifi());
        televisionDto.setWifi(television.getWifi());
        televisionDto.setVoiceControl(television.getVoiceControl());
        televisionDto.setHdr(television.getHdr());
        televisionDto.setBluetooth(television.getBluetooth());
        televisionDto.setAmbiLight(television.getAmbiLight());
        televisionDto.setOriginalStock(television.getOriginalStock());
        televisionDto.setSold(television.getSold());
        televisionDto.setRemoteController(television.getRemoteController());

        return televisionDto;
    }


    public List<TelevisionDto> getAllTelevisionsByBrand(String brand) {
        List<Television> televisionsByBrand = televisionRepos.findByBrand(brand);
        List<TelevisionDto> televisionsDto = new ArrayList<>();

        for (Television television : televisionsByBrand) {
            TelevisionDto televisionDto = transferToDto(television);
            televisionsDto.add(televisionDto);
        }

        return televisionsDto;

    }


    public List<TelevisionDto> getAllTelevisions() {
        List<Television> televisions = televisionRepos.findAll();
        List<TelevisionDto> televisionsDto = new ArrayList<>();

        for (Television television : televisions) {
            TelevisionDto televisionDto = transferToDto(television);
            televisionsDto.add(televisionDto);
        }
        return televisionsDto;

    }

    public void addRemoteController(Long televisionid, Long remotecontrollerid) {

        Optional<RemoteController> remoteController = remoteControllerRepos.findById(remotecontrollerid);
        if (remoteController.isPresent()) {
            Optional<Television> televisionOptional = televisionRepos.findById(televisionid);
            if (televisionOptional.isPresent()) {
                RemoteController r = remoteController.get();
                Television t = televisionOptional.get();
                t.setRemoteController(r);
                televisionRepos.save(t);
            }

        }
    }

}