package com.example.demo.models;

import lombok.Data;

@Data
public class BookLombok {
    private int id;
    private String author;
    private String title;

    public BookLombok(){}

    public BookLombok(int id, String author, String title){
        this.id = id;
        this.author = author;
        this.title = title;
    }

}
