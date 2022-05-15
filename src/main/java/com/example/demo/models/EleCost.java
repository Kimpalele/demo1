package com.example.demo.models;

import lombok.Data;

@Data
public class EleCost {
    String date;
    int cost;

    public EleCost(){}

    public EleCost(String date, int cost){
        this.date = date;
        this.cost = cost;
    }
}
