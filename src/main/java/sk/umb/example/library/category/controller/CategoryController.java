package sk.umb.example.library.category.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class CategoryController {
    @GetMapping("/api/category")
    public List<Object> listResource(@RequestParam(required = false) String name){
        return Collections.emptyList();
    }
    @GetMapping("/api/category/{id}")
    public void retrieveDetail(@PathVariable long id){
        System.out.println("Printing category at id:"+id);
    }
    @PostMapping("/api/category")
    public void createResource(){
        System.out.println("Added category");
    }
    @PutMapping("/api/category/{categoryId}")
    public void updateResource(@PathVariable long categoryId){
        System.out.println("Updated category at:" + categoryId);
    }
    @DeleteMapping("/api/category/{categoryId}")
    public void deleteResource(@PathVariable long categoryId){
        System.out.println("Deleted category:" + categoryId);
    }
}
