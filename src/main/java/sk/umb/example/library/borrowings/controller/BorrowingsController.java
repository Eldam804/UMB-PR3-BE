package sk.umb.example.library.borrowings.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class BorrowingsController {
    @GetMapping("/api/borrowings")
    public List<Object> searchBorrowed(@RequestParam(required = false) String name){
        return Collections.emptyList();
    }
    @GetMapping("/api/borrowings/{id}")
    public void getBorrow(@PathVariable long id){
        System.out.println("Printing Borrow at id:"+id);
    }
    @PostMapping("/api/borrowings")
    public void addBorrow(){
        System.out.println("Added Borrow");
    }
    @PutMapping("/api/borrowings/{borrowingsId}")
    public void updateBorrow(@PathVariable long borrowingsId){
        System.out.println("Updated Borrow at:" + borrowingsId);
    }
    @DeleteMapping("/api/borrowings/{borrowingsId}")
    public void deleteBorrow(@PathVariable long borrowingsId){
        System.out.println("Deleted Borrow: " + borrowingsId);
    }
}



