package com.example.demo.models;

import lombok.Data;

@Data
public class Humid {

    String date;
    int morning;
    int noon;
    int dusk;

    public Humid(){}

    public Humid(String date, int morning, int noon, int dusk){
        this.date = date;
        this.morning = morning;
        this.noon = noon;
        this.dusk = dusk;
    }
}
