package sk.umb.example.library.borrowings.controller;

import org.springframework.web.bind.annotation.*;
import sk.umb.example.library.book.service.BookDetailDto;
import sk.umb.example.library.book.service.BookDetailRequestDto;
import sk.umb.example.library.borrowings.service.BorrowingDetailDto;
import sk.umb.example.library.borrowings.service.BorrowingDetailRequestDto;
import sk.umb.example.library.borrowings.service.BorrowingsService;
import sk.umb.example.library.customer.service.CustomerDto;
import sk.umb.example.library.customer.service.CustomerRequestDto;

import java.util.Collections;
import java.util.List;

@RestController
public class BorrowingsController {
    private BorrowingsService borrowingsService;

    public BorrowingsController(BorrowingsService borrowingsService) {
        this.borrowingsService = borrowingsService;
    }

    @GetMapping("/api/borrowings")
    public List<BorrowingDetailDto> getAllBorrowings(@RequestParam(required = false) String name){
        return this.borrowingsService.getAllBorrowings();
    }
    @GetMapping("/api/borrowings/{id}")
    public BorrowingDetailDto getBorrowingById(@PathVariable long id){
        return this.borrowingsService.getBorrowingById(id);
    }
    @PostMapping("/api/borrowings")
    public Long createBorrowing(@RequestBody BorrowingDetailRequestDto borrowingDetailRequestDto){
        return this.borrowingsService.createBorrowing(borrowingDetailRequestDto);
    }
    @PutMapping("/api/borrowings/{borrowingsId}")
    public void updateBorrowings(@PathVariable long borrowingsId, @RequestBody BorrowingDetailRequestDto borrowingDetailRequestDto){
        this.borrowingsService.updateBorrowing(borrowingsId, borrowingDetailRequestDto);
    }
    @DeleteMapping("/api/borrowings/{borrowingsId}")
    public void deleteResource(@PathVariable long borrowingsId){
        System.out.println("Deleted Borrow: " + borrowingsId);
    }
}



