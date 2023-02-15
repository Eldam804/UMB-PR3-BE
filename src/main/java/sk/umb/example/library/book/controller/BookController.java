package sk.umb.example.library.book.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class BookController {
    @GetMapping("/api/books")
    public List<Object> searchBooks(@RequestParam(required = false) String name){
        return Collections.emptyList();
    }
    @GetMapping("/api/books/{id}")
    public void getBook(@PathVariable long id){
        System.out.println("Printing book at id:"+id);
    }
    @PostMapping("/api/books")
    public void addBook(){
        System.out.println("Added book");
    }
    @PutMapping("/api/books/{bookId}")
    public void updateBook(@PathVariable long bookId){
        System.out.println("Updated book at:" + bookId);
    }
    @DeleteMapping("/api/books/{bookId}")
    public void deleteBook(@PathVariable long bookId){
        System.out.println("Deleted book: " + bookId);
    }
}
