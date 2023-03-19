package sk.umb.example.library.book.service;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.umb.example.library.book.persistence.BookRepository;
import sk.umb.example.library.book.persistence.entity.BookEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    private final List<BookDetailDto> books = new ArrayList<>();
    public List<BookDetailDto> getAllBooks(){
        return mapToDtoList(bookRepository.findAll());
    }
    public BookDetailDto getBookById(Long bookId){
        return mapToDto(getBookEntityById(bookId));
    }

    private BookEntity getBookEntityById(Long bookId) {
        Optional<BookEntity> bookEntity = bookRepository.findById(bookId);
        if(bookEntity.isEmpty()){
            throw new IllegalArgumentException("Book not found at ID:"+ bookId);
        }
        return bookEntity.get();
    }
    public Long createBook(BookDetailRequestDto bookDetailRequestDto){
        BookEntity bookEntity = mapToEntity(bookDetailRequestDto);
        return bookRepository.save(bookEntity).getId();
    }
    public void updateBook(Long bookId, BookDetailRequestDto book){
        BookEntity bookEntity = getBookEntityById(bookId);
        if (!Strings.isEmpty(book.getAuthorFirstName())){
            bookEntity.setAuthorFirstName(book.getAuthorFirstName());
        }
        if (!Strings.isEmpty(book.getAuthorLastName())){
            bookEntity.setAuthorLastName(book.getAuthorLastName());
        }
        if (!Strings.isEmpty(book.getTitle())){
            bookEntity.setTitle(book.getTitle());
        }
        if (!Strings.isEmpty(book.getIsbn())){
            bookEntity.setIsbn(book.getIsbn());
        }
        bookRepository.save(bookEntity);
    }
    public void deleteBook(Long bookId){
        bookRepository.deleteById(bookId);
    }

    private BookEntity mapToEntity(BookDetailRequestDto bookDetailRequestDto) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setAuthorFirstName(bookDetailRequestDto.getAuthorFirstName());
        bookEntity.setAuthorLastName(bookDetailRequestDto.getAuthorLastName());
        bookEntity.setIsbn(bookDetailRequestDto.getIsbn());
        bookEntity.setTitle(bookDetailRequestDto.getTitle());
        bookEntity.setCount(bookDetailRequestDto.getCount());
        return bookEntity;
    }


    private List<BookDetailDto> mapToDtoList(Iterable<BookEntity> bookEntity){
        List<BookDetailDto> bookDetailDtos = new ArrayList<>();
        bookEntity.forEach(bookEntity1 -> {
           BookDetailDto bookDetailDto = mapToDto(bookEntity1);
           bookDetailDtos.add(bookDetailDto);
        });
        return bookDetailDtos;
    }
    private BookDetailDto mapToDto(BookEntity bookEntity){
        BookDetailDto bookDetailDto = new BookDetailDto();
        bookDetailDto.setId(bookEntity.getId());
        bookDetailDto.setTitle(bookEntity.getTitle());
        bookDetailDto.setAuthorFirstName(bookEntity.getAuthorFirstName());
        bookDetailDto.setAuthorLastName(bookEntity.getAuthorLastName());
        bookDetailDto.setIsbn(bookEntity.getIsbn());
        bookDetailDto.setCount(bookEntity.getCount());
        return bookDetailDto;
    }
}
