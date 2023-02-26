package sk.umb.example.library.service;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CustomerService {
   private final List<CustomerDto> customers = new ArrayList<>();



      public List<CustomerDto> getAllCustomers(){
         return customers;
      }





}
