package sk.umb.example.library.borrowings.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.umb.example.library.book.service.BookDetailRequestDto;
import sk.umb.example.library.book.service.BookService;
import sk.umb.example.library.customer.controller.CustomerController;
import sk.umb.example.library.customer.service.CustomerService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BorrowingsService {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private BookService bookService;
    private List<BorrowingDetailDto> borrowings = new ArrayList<>();


    public List<BorrowingDetailDto> getAllBorrowings(){
        return this.borrowings;
    }
    public BorrowingDetailDto getBorrowingById(Long borrowingId){
        int index = borrowingId.intValue();
        if(index < borrowings.size()){
            return borrowings.get(index);
        }
        return new BorrowingDetailDto();
    }

    public Long createBorrowing(BorrowingDetailRequestDto borrowingDetailRequestDto) {
        BorrowingDetailDto borrowingDetailDto1 = new BorrowingDetailDto();
        borrowingDetailDto1.setCustomerDto(customerService.getCustomerById(borrowingDetailRequestDto.getCustomerId()));
        borrowingDetailDto1.setBookDetailDto(bookService.getBookById(borrowingDetailRequestDto.getBookId()));
        borrowingDetailDto1.setId((long) borrowings.size());
        borrowingDetailDto1.setDate(new Date());
        if(borrowingDetailDto1.getCustomerDto().getId() == null || borrowingDetailDto1.getBookDetailDto().getId() == null){
            return -1L;
        }
        this.borrowings.add(borrowingDetailDto1);
        return 0L;
    }
    public void updateBorrowing(Long borrowingId, BorrowingDetailRequestDto borrowingDetailRequestDto){
        int index = borrowingId.intValue();
        if(index < borrowings.size()){
            borrowings.get(index).setCustomerDto(this.customerService.getCustomerById(borrowingDetailRequestDto.getCustomerId()));
            borrowings.get(index).setBookDetailDto(this.bookService.getBookById(borrowingDetailRequestDto.getBookId()));
        }
    }

}
