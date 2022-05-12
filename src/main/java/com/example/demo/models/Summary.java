package com.example.demo.models;

import lombok.Data;

@Data
public class Summary {
    String date;
    int morningT;
    int morningH;
    int noonT;
    int noonH;
    int duskT;
    int duskH;
    int cost;

    public Summary(String date, int mTemp, int mHumid, int nTemp, int nHumid, int dTemp, int dHumid, int cost){
        this.date = date;
        this.morningT = mTemp;
        this.morningH = mHumid;
        this.noonT = nTemp;
        this.noonH = nHumid;
        this.duskT = dTemp;
        this.duskH = dHumid;
        this.cost = cost;
    }
}
