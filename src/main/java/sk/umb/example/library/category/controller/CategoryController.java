package sk.umb.example.library.category.controller;

import org.springframework.web.bind.annotation.*;
import sk.umb.example.library.category.service.CategoryDto;
import sk.umb.example.library.category.service.CategoryRequestDto;
import sk.umb.example.library.category.service.CategoryService;

import java.util.Collections;
import java.util.List;

@RestController
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/api/category")
    public List<CategoryDto> listResource(@RequestParam(required = false) String name){
        return this.categoryService.getAllcategories();
    }
    @GetMapping("/api/category/{id}")
    public CategoryDto retrieveDetail(@PathVariable long id){
        return this.categoryService.getCategoryById(id);
    }
    @PostMapping("/api/category")
    public CategoryDto createResource(@RequestBody CategoryRequestDto categoryRequestDto){
        return this.categoryService.createNewCategory(categoryRequestDto);
    }
    @PutMapping("/api/category/{categoryId}")
    public void updateResource(@PathVariable long categoryId,@RequestBody CategoryRequestDto categoryRequestDto){
        categoryService.updateCategory(categoryId,categoryRequestDto);
    }
    @DeleteMapping("/api/category/{categoryId}")
    public void deleteResource(@PathVariable long categoryId){
        System.out.println("Deleted category:" + categoryId);
    }
}
