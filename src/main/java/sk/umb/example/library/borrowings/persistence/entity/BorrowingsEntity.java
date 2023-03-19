package sk.umb.example.library.borrowings.persistence.entity;

import sk.umb.example.library.book.service.BookDetailDto;
import sk.umb.example.library.customer.service.CustomerDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class BorrowingsEntity {
    @Id
    @GeneratedValue
    private Long id;
    private Long bookDetailId;
    private Long customerDetailId;
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookDetailId() {
        return bookDetailId;
    }

    public void setBookDetailId(Long bookDetailId) {
        this.bookDetailId = bookDetailId;
    }

    public Long getCustomerDetailId() {
        return customerDetailId;
    }

    public void setCustomerDetailId(Long customerDetailId) {
        this.customerDetailId = customerDetailId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
