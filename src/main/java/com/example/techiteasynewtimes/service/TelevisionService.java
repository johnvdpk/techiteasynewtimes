package com.example.techiteasynewtimes.service;

import com.example.techiteasynewtimes.controllers.TelevisionController;
import com.example.techiteasynewtimes.dtos.TelevisionDto;
import com.example.techiteasynewtimes.dtos.TelevisionInputDto;
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


    // Television naar televisionDto. (Television van uit de database naar Dto waar de controller weer mee communiceerd).
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

    // inputDto naar Television ( Controller naar televison naar repos. naar database)
    public Television transferToTelevision(TelevisionInputDto televisionInputDto) {
        Television television = new Television();

        television.setId(televisionInputDto.getId());
        television.setType(televisionInputDto.getType());
        television.setBrand(televisionInputDto.getBrand());
        television.setName(televisionInputDto.getName());
        television.setPrice(televisionInputDto.getPrice());
        television.setAvailableSize(televisionInputDto.getAvailableSize());
        television.setRefreshRate(televisionInputDto.getRefreshRate());
        television.setScreenType(televisionInputDto.getScreenType());
        television.setScreenQuality(televisionInputDto.getScreenQuality());
        television.setSmartTv(televisionInputDto.getSmartTv());
        television.setWifi(televisionInputDto.getWifi());
        television.setVoiceControl(televisionInputDto.getVoiceControl());
        television.setHdr(televisionInputDto.getHdr());
        television.setBluetooth(televisionInputDto.getBluetooth());
        television.setAmbiLight(televisionInputDto.getAmbiLight());
        television.setOriginalStock(televisionInputDto.getOriginalStock());
        television.setSold(televisionInputDto.getSold());
        television.setRemoteController(televisionInputDto.getRemoteController());


        return television;

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
        List<TelevisionDto> televisionsDtos = new ArrayList<>();

        for (Television television : televisions) {
            TelevisionDto televisionDto = transferToDto(television);
            televisionsDtos.add(televisionDto);
        }
        return televisionsDtos;

    }

    public TelevisionDto getTelevisionById(Long id) {
        Optional<Television> televisionOptional = televisionRepos.findById(id);
        TelevisionDto televisionDto = new TelevisionDto();

        if (televisionOptional.isPresent()) {
            Television televisionEntity = televisionOptional.get();
            televisionDto = transferToDto(televisionEntity);


        }

        return televisionDto;
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


//         Dit is volgensmij hetzelfde als transfer tot television
//    public TelevisionInputDto createTelevision(TelevisionInputDto televisionInputDto) {
//        Television television = new Television();
//
//        television.setId(televisonInputDto.setid);
//        television.setType(televisonInputDto.type);
//        television.setBrand(televisonInputDto.brand);
//        television.setName(televisonInputDto.name);
//        television.setPrice(televisonInputDto.price);
//        television.setAvailableSize(televisonInputDto.availableSize);
//        television.setRefreshRate(televisonInputDto.refreshRate);
//        television.setScreenType(televisonInputDto.screenType);
//        television.setScreenQuality(televisonInputDto.screenQuality);
//        television.setSmartTv(televisonInputDto.smartTv);
//        television.setWifi(televisonInputDto.wifi);
//        television.setVoiceControl(televisonInputDto.voiceControl);
//        television.setHdr(televisonInputDto.hdr);
//        television.setBluetooth(televisonInputDto.bluetooth);
//        television.setAmbiLight(televisonInputDto.ambiLight);
//        television.setOriginalStock(televisonInputDto.originalStock);
//        television.setSold(televisonInputDto.sold);
//        television = televisionRepos.save(television);
//
//        return televisionDto;
//        }



}