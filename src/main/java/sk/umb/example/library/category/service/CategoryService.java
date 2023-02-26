package sk.umb.example.library.category.service;

import org.springframework.stereotype.Service;
import sk.umb.example.library.category.service.CategoryDto;
import sk.umb.example.library.category.service.CategoryRequestDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    private final List<CategoryDto> categories = new ArrayList<>();


    public List<CategoryDto> getAllcategories() {
        return categories;
    }

    public CategoryDto getCategoryById(Long customerId) {
        int index = customerId.intValue();
        if(index < categories.size()){
            return categories.get(index);
        }
        return new CategoryDto();
    }

    public CategoryDto createNewCategory(CategoryRequestDto category) {
        Long categoryId = (long)categories.size();
        CategoryDto categoryDto = mapTocategoryDto(category);
        categoryDto.setId(categoryId);
        categories.add(categoryDto);
        return categoryDto;

    }
    private static CategoryDto mapTocategoryDto(CategoryRequestDto categoryRequestDto){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(categoryRequestDto.getName());
        return categoryDto;
    }

    public void updateCategory(Long customerId, CategoryRequestDto categoryRequestDto) {
        int index = customerId.intValue();
        CategoryDto categoryDto = mapTocategoryDto(categoryRequestDto);
        if(index < categories.size()){
            categories.get(index).setName(categoryDto.getName());
        }
    }
}
