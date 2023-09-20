package com.example.techiteasynewtimes.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="wall_brackets")
public class WallBracket {

    @Id
    @GeneratedValue
    private Long id;

    private String size;
    private Boolean ajustable;

    private String name;

    private Double price;

    @ManyToMany (mappedBy = "wallBrackets")
    private List<Television> televisions;


    public WallBracket(Long id, String size, Boolean ajustable, String name, Double price) {
        this.id = id;
        this.size = size;
        this.ajustable = ajustable;
        this.name = name;
        this.price = price;
    }

    public WallBracket(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Boolean getAjustable() {
        return ajustable;
    }

    public void setAjustable(Boolean ajustable) {
        this.ajustable = ajustable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
