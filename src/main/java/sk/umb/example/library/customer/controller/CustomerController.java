package sk.umb.example.library.customer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class CustomerController {

    @GetMapping("/api/customers")
    public List<Object> searchCustomers(@RequestParam(required = false) String lastName){
        return Collections.emptyList();
    }
}
