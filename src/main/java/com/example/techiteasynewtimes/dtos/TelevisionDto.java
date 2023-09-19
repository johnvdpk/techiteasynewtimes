package com.example.techiteasynewtimes.dtos;
import jakarta.validation.constraints.NotBlank;


public class TelevisionDto {

    public Long id;

    public String type;
    @NotBlank
    public String brand;
    @NotBlank
    public String name;
    public Double price;
    public Double availableSize;
    public Double refreshRate;
    public String screenType;
    public String screenQuality;
    public Boolean smartTv;
    public Boolean wifi;
    public Boolean voiceControl;
    public Boolean hdr;
    public Boolean bluetooth;
    public Boolean ambiLight;
    public Integer originalStock;
    public Integer sold;

}
