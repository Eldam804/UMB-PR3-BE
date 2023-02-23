package sk.umb.example.library.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.umb.example.library.book.service.BookDetailDto;
import sk.umb.example.library.book.service.BookDetailRequestDto;
import sk.umb.example.library.book.service.BookService;

import java.util.Collections;
import java.util.List;

@RestController
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/api/books")
    public List<BookDetailDto> getBooks(){
        return bookService.getAllBooks();
    }
    @GetMapping("/api/books/{bookId}")
    public BookDetailDto getBookById(@PathVariable long bookId){
        return bookService.getBookById(bookId);
    }
    @PostMapping("/api/books")
    public BookDetailDto createBook(@RequestBody BookDetailRequestDto bookDetailRequestDto){
        return bookService.createBook(bookDetailRequestDto);
    }
    @PutMapping("/api/books/{bookId}")
    public void updateBook(@PathVariable long bookId, @RequestBody BookDetailRequestDto bookDetailRequestDto){
        bookService.updateBook(bookId, bookDetailRequestDto);
    }
    @DeleteMapping("/api/books/{bookId}")
    public void deleteResource(@PathVariable long bookId){
        System.out.println("Deleted book: " + bookId);
    }
}
