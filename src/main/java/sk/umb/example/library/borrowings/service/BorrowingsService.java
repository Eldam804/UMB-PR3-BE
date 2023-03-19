package sk.umb.example.library.borrowings.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.umb.example.library.book.service.BookDetailDto;
import sk.umb.example.library.book.service.BookDetailRequestDto;
import sk.umb.example.library.book.service.BookService;
import sk.umb.example.library.borrowings.persistence.BorrowingsRepository;
import sk.umb.example.library.borrowings.persistence.entity.BorrowingsEntity;
import sk.umb.example.library.customer.controller.CustomerController;
import sk.umb.example.library.customer.service.CustomerDto;
import sk.umb.example.library.customer.service.CustomerService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowingsService {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private BookService bookService;
    @Autowired
    private BorrowingsRepository borrowingsRepository;
    private List<BorrowingDetailDto> borrowings = new ArrayList<>();


    public List<BorrowingDetailDto> getAllBorrowings(){
        return mapToDoList(borrowingsRepository.findAll());
    }

    public BorrowingDetailDto getBorrowingById(Long borrowingId){
        return mapToDto(getBorrowingsEntityById(borrowingId));
    }



    public Long createBorrowing(BorrowingDetailRequestDto borrowingDetailRequestDto) {
        BorrowingsEntity entity = mapToNewDto(borrowingDetailRequestDto);
        return borrowingsRepository.save(entity).getId();
    }

    public void updateBorrowing(Long borrowingId, BorrowingDetailRequestDto borrowingDetailRequestDto){
        BorrowingsEntity borrowingsEntity = getBorrowingsEntityById(borrowingId);
        if(borrowingDetailRequestDto.getBookId() != null){
            borrowingsEntity.setBookDetailId(borrowingDetailRequestDto.getBookId());
        }
        if(borrowingDetailRequestDto.getCustomerId() != null ){
            borrowingsEntity.setCustomerDetailId(borrowingDetailRequestDto.getCustomerId());
        }

        borrowingsRepository.save(borrowingsEntity);
    }

    public void deleteBorrowing(Long borrowingId){
        borrowingsRepository.deleteById(borrowingId);
    }





    private List<BorrowingDetailDto> mapToDoList(Iterable<BorrowingsEntity> all) {
        List<BorrowingDetailDto> borrowingDetailDtos = new ArrayList<>();
        all.forEach(borrowingsEntity -> {
            BorrowingDetailDto dto = mapToDto(borrowingsEntity);
            borrowingDetailDtos.add(dto);
        });
        return borrowingDetailDtos;
    }
    private BorrowingDetailDto mapToDto(BorrowingsEntity borrowingsEntity){
        BorrowingDetailDto borrowingDetailDto = new BorrowingDetailDto();
        borrowingDetailDto.setCustomerDto(customerService.getCustomerById(borrowingsEntity.getCustomerDetailId()));
        borrowingDetailDto.setBookDetailDto(bookService.getBookById(borrowingsEntity.getBookDetailId()));
        borrowingDetailDto.setDate(borrowingsEntity.getDate());
        borrowingDetailDto.setId(borrowingsEntity.getId());
        return borrowingDetailDto;
    }
    private BorrowingsEntity getBorrowingsEntityById(Long borrowingId) {
        Optional<BorrowingsEntity> borrowingsEntity = borrowingsRepository.findById(borrowingId);
        if(borrowingsEntity.isEmpty()){
            throw new IllegalArgumentException("No borrowing at id:" + borrowingId);
        }
        return borrowingsEntity.get();
    }
    private BorrowingsEntity mapToNewDto(BorrowingDetailRequestDto borrowingDetailRequestDto) {
        BookDetailDto book = bookService.getBookById(borrowingDetailRequestDto.getBookId());
        CustomerDto customer = customerService.getCustomerById(borrowingDetailRequestDto.getCustomerId());
        /*if(book.getId() == null){
            throw new IllegalArgumentException("No book at id:" + borrowingDetailRequestDto.getBookId() );
        }
        if(customer.getId() == null){
            throw new IllegalArgumentException("No customer at id: " + borrowingDetailRequestDto.getCustomerId());
        }*/
        BorrowingsEntity entity = new BorrowingsEntity();
        entity.setBookDetailId(book.getId());
        entity.setCustomerDetailId(customer.getId());
        entity.setDate(new Date());
        return entity;
    }
}
