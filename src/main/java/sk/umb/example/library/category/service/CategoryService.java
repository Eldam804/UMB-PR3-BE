package sk.umb.example.library.category.service;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.umb.example.library.book.persistence.entity.BookEntity;
import sk.umb.example.library.category.perzistence.GenreRepository;
import sk.umb.example.library.category.perzistence.entity.GenreEntity;
import sk.umb.example.library.category.service.CategoryDto;
import sk.umb.example.library.category.service.CategoryRequestDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private GenreRepository genreRepository;
    private final List<CategoryDto> categories = new ArrayList<>();


    public List<CategoryDto> getAllcategories() {
        return mapToDtoList(genreRepository.findAll());
    }

    public CategoryDto getCategoryById(Long categoryId) {
        return maptoDto(getGenreEntityById(categoryId));
    }

    private GenreEntity getGenreEntityById(Long genreId){
        Optional<GenreEntity> genreEntity = genreRepository.findById(genreId);
        if(genreEntity.isEmpty()){
            throw new IllegalArgumentException("Genre not found at ID:" + genreId);
        }
        return genreEntity.get();
     }
     public Long createGenre(CategoryRequestDto categoryRequestDto){
        GenreEntity genreEntity = maptoEntity(categoryRequestDto);
        return genreRepository.save(genreEntity).getId();
     }
    public void  updateGenre(Long genreId,CategoryRequestDto genre){
        GenreEntity genreEntity = getGenreEntityById(genreId);
        if(!Strings.isEmpty(genre.getName())){
            genreEntity.setName(genre.getName());
        }
        genreRepository.save(genreEntity);
    }
    public void deleteGenre(Long genreId){genreRepository.deleteById(genreId);}

    private List<CategoryDto> mapToDtoList(Iterable<GenreEntity> genreEntity) {
        List<CategoryDto> categoryDtos = new ArrayList<>();
        genreEntity.forEach(genreEntity1 -> {
            CategoryDto categoryDto = maptoDto(genreEntity1);
            categoryDtos.add(categoryDto);
        });
        return categoryDtos;
    }
    private CategoryDto maptoDto(GenreEntity genreEntity){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(genreEntity.getId());
        categoryDto.setName(categoryDto.getName());
        return categoryDto;
    }
    private  GenreEntity maptoEntity(CategoryRequestDto categoryRequestDto){
        GenreEntity genreEntity = new GenreEntity();
        genreEntity.setName(categoryRequestDto.getName());
        return genreEntity;
    }


//    public CategoryDto getCategoryById(Long customerId) {
//        int index = customerId.intValue();
//        if(index < categories.size()){
//            return categories.get(index);
//        }
//        return new CategoryDto();
//    }

//    public CategoryDto createNewCategory(CategoryRequestDto category) {
//        Long categoryId = (long)categories.size();
//        CategoryDto categoryDto = mapTocategoryDto(category);
//        categoryDto.setId(categoryId);
//        categories.add(categoryDto);
//        return categoryDto;
//
//    }
//    private static CategoryDto mapTocategoryDto(CategoryRequestDto categoryRequestDto){
//        CategoryDto categoryDto = new CategoryDto();
//        categoryDto.setName(categoryRequestDto.getName());
//        return categoryDto;
//    }
//
//    public void updateCategory(Long customerId, CategoryRequestDto categoryRequestDto) {
//        int index = customerId.intValue();
//        CategoryDto categoryDto = mapTocategoryDto(categoryRequestDto);
//        if(index < categories.size()){
//            categories.get(index).setName(categoryDto.getName());
//        }
//    }
}
