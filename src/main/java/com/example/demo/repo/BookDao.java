package com.example.demo.repo;

import com.example.demo.models.BookLombok;

import java.util.ArrayList;
import java.util.List;

public class BookDao {
    List<BookLombok> books = new ArrayList<BookLombok>();

    public BookDao(){
        BookLombok b1 = new BookLombok();
        b1.setId(1);
        b1.setAuthor("Astrid");
        b1.setTitle("Ronja Rövardotter");

        BookLombok b2 = new BookLombok();
        b2.setId(2);
        b2.setAuthor("Kim");
        b2.setTitle("Alexander the great");

        BookLombok b3 = new BookLombok();
        b3.setId(3);
        b3.setAuthor("Lindgren");
        b3.setTitle("Bröderna Lejonhjärta");

        books.add(b1);
        books.add(b2);
        books.add(b3);
    }

    public List<BookLombok> getList(){
        return books;
    }
}
