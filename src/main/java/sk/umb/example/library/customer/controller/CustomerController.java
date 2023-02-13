package sk.umb.example.library.customer.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class CustomerController {

    @GetMapping("/api/customers")
    public List<Object> searchCustomers(@RequestParam(required = false) String lastName){
        return Collections.emptyList();
    }
    @GetMapping("/api/customers/{customerId}")
    public void getCustomer(@PathVariable Long customerId){
        System.out.println("get customer called ID:" + customerId);
    }
    @PostMapping("/api/customers")
    public void createCustomer(){
        System.out.println("Created customer");
    }

    @PutMapping("/api/customers/{customerId}")
    public void updateCustomer(@PathVariable Long customerId){
        System.out.println("Update customer at:" + customerId);
    }
    @DeleteMapping("/api/customers/{customerId}")
    public void deleteCustomer(@PathVariable Long customerId){
        System.out.println("Customer with ID:" + customerId);
    }
}
