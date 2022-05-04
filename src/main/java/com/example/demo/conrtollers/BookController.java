package com.example.demo.conrtollers;


import com.example.demo.models.Book;
import com.example.demo.models.BookLombok;
import com.example.demo.models.Response;
import com.example.demo.repo.BookDao;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    BookDao bd = new BookDao();
    List<BookLombok> books = bd.getList();

    @RequestMapping("/books")
    public List<BookLombok> getAllBooks(){
        return books;
    }

    @RequestMapping("/books/{id}")
    public BookLombok getBookById(@PathVariable int id){
        BookLombok temp = new BookLombok();
        for (BookLombok b : books){
            if (b.getId() == id){
                temp = b;
            }
        }
        return temp;
    }

    @RequestMapping("/booksAuthor/{author}")
    public BookLombok getBookByAuthor(@PathVariable String author){
        BookLombok temp = new BookLombok();
        for (BookLombok b : books){
            if (b.getAuthor().equalsIgnoreCase(author)){
                temp = b;
            }
        }
        return temp;
    }

    @PostMapping("/books/add")
    public Response addBook(@RequestBody BookLombok b){
        System.out.println(b.getId() + " " + b.getAuthor() + " " + b.getTitle());
        Response res = new Response("Book added",Boolean.FALSE);
        books.add(b);
        res.setStatus(Boolean.TRUE);
        return res;
    }

    @DeleteMapping("books/del/{id}")
    public Response deleteBookById(@PathVariable("id") int id){
        Response res = new Response("Error deleting book..", Boolean.FALSE);

        int removeIndex = -1;
        for (int i = 0; i < books.size(); i++){
            if (books.get(i).getId() == id){
                removeIndex = i;
            }
        }

        if (removeIndex != -1){
            books.remove(removeIndex);
            res.setMessage("Book successfully removed!");
            res.setStatus(Boolean.TRUE);
        }
        return res;
    }


}
