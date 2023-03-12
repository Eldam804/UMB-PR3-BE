package sk.umb.example.library.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.umb.example.library.customer.service.CustomerDto;
import sk.umb.example.library.customer.service.CustomerRequestDto;
import sk.umb.example.library.customer.service.CustomerService;

import java.util.Collections;
        import java.util.List;

@RestController
public class CustomerController {
    private final CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/api/customer")
    public List<CustomerDto> getCustomers(@RequestParam(required = false) String lastName){
        System.out.println("Search Customer called.");
        return customerService.getAllCustomers();
        //return Collections.emptyList();
    }

    @PostMapping("/api/customer")
    public Long createCustomers(@RequestBody CustomerRequestDto customerId) {
        return customerService.createNewCustomer(customerId);
    }
    @GetMapping("/api/customer/{customerId}")
    public CustomerDto getCustomer(@PathVariable Long customerId){
        System.out.println("get customer called ID:" + customerId);
        return customerService.getCustomerById(customerId);
    }
    @PutMapping("/api/customer/{customerId}")
    public void updateCustomer(@PathVariable Long customerId, @RequestBody CustomerRequestDto customer){
        System.out.println("update customer called: id = " + customerId);

        customerService.updateCustomer(customerId, customer);
    }

    @DeleteMapping("/api/customer/{customerId}")
    public void deleteCustomer(@PathVariable Long customerId){
        customerService.deleteCustomer(customerId);
    }


}
