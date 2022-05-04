package com.example.demo.models;

import lombok.Data;

@Data
public class KompisLombok {

    int id;
    String name;
    String adress;
    int phoneNumber;

    public KompisLombok(){}

    public KompisLombok(int id, String name, String adress, int phoneNumber) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
    }
}
