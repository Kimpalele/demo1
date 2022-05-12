package com.example.demo.models;

import lombok.Data;

@Data
public class Temp {
    String date;
    int morning;
    int noon;
    int dusk;

    public Temp(){}

    public Temp(String date,int morning, int noon, int dusk){
        this.date = date;
        this.morning = morning;
        this.noon = noon;
        this.dusk = dusk;
    }
}
