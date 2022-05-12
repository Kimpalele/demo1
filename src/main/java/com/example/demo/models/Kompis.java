package com.example.demo.models;

import lombok.Data;

@Data
public class Kompis {

    int id;
    String name;
    String adress;
    int phoneNumber;

    public Kompis(){}

    public Kompis(int id, String name, String adress, int phoneNumber) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
    }
}
