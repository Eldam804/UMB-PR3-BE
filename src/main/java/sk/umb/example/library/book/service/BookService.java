package sk.umb.example.library.book.service;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    private final List<BookDetailDto> books = new ArrayList<>();
    public List<BookDetailDto> getAllBooks(){
        return this.books;
    }
    public BookDetailDto getBookById(Long bookId){
        int index = bookId.intValue();
        if(bookId < books.size()){
            return this.books.get(index);
        }
        return new BookDetailDto();
    }

    private BookDetailDto mapToBookDetailDto(BookDetailRequestDto bookDetailRequestDto){
        BookDetailDto bookDetailDto = new BookDetailDto();
        bookDetailDto.setCount(bookDetailRequestDto.getCount());
        bookDetailDto.setAuthorFirstName(bookDetailRequestDto.getAuthorFirstName());
        bookDetailDto.setAuthorLastName(bookDetailRequestDto.getAuthorLastName());
        bookDetailDto.setTitle(bookDetailRequestDto.getTitle());
        bookDetailDto.setIsbn(bookDetailRequestDto.getIsbn());
        return bookDetailDto;
    }
    public BookDetailDto createBook(BookDetailRequestDto bookDetailRequestDto){
        Long customerId = (long)books.size();
        BookDetailDto bookDetailDto = new BookDetailDto();
        bookDetailDto = mapToBookDetailDto(bookDetailRequestDto);
        bookDetailDto.setId(customerId);
        return new BookDetailDto();
    }

    public void updateBook(Long bookId, BookDetailRequestDto bookDetailRequestDto){
        int index = bookId.intValue();
        BookDetailDto bookDetailDto = mapToBookDetailDto(bookDetailRequestDto);
        if(bookId < books.size()){
            books.get(index).setAuthorFirstName(bookDetailDto.getAuthorFirstName());
            books.get(index).setAuthorLastName(bookDetailDto.getAuthorLastName());
            books.get(index).setCount(bookDetailDto.getCount());
            books.get(index).setTitle(bookDetailDto.getTitle());
            books.get(index).setIsbn(bookDetailDto.getIsbn());
        }
    }
}
