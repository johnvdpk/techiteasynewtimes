package com.example.techiteasynewtimes.service;

import com.example.techiteasynewtimes.dtos.TelevisionDto;
import com.example.techiteasynewtimes.models.Television;
import com.example.techiteasynewtimes.repository.TelevisionRepository;
import org.springframework.stereotype.Service;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepos;

    public TelevisionService (TelevisionRepository televisionRepos) {
        this.televisionRepos = televisionRepos;
    }

    public TelevisionDto createTelevision(TelevisionDto televisionDto) {
        Television television = new Television();

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
        televisionRepos.save(television);

        return televisionDto;



    }

}
