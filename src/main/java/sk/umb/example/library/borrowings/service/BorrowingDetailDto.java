package sk.umb.example.library.borrowings.service;

import sk.umb.example.library.book.service.BookDetailDto;
import sk.umb.example.library.customer.service.CustomerDto;

import java.util.Date;

public class BorrowingDetailDto {
    private Long id;
    private BookDetailDto bookDetailDto;
    private CustomerDto customerDto;
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BookDetailDto getBookDetailDto() {
        return bookDetailDto;
    }

    public void setBookDetailDto(BookDetailDto bookDetailDto) {
        this.bookDetailDto = bookDetailDto;
    }

    public CustomerDto getCustomerDto() {
        return customerDto;
    }

    public void setCustomerDto(CustomerDto customerDto) {
        this.customerDto = customerDto;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
