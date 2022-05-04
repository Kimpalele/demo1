package com.example.demo.models;

import java.io.Serializable;

public class Kompis implements Serializable {

    int id;
    String name;
    String adress;
    int phoneNumber;

    public Kompis(int id, String name, String adress, int phoneNumber) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPersonalInfo() {
        return "Name: " + name + " - Age: " + adress + " - Height: " + phoneNumber + " - Id: " + id;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String adress) {
        this.adress = adress;
    }

    public void setHeight(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
