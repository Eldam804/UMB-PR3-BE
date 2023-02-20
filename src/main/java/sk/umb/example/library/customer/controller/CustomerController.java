package sk.umb.example.library.customer.controller;

import org.springframework.web.bind.annotation.*;

        import java.util.Collections;
        import java.util.List;

@RestController
public class CustomerController {

    @GetMapping("/api/customer")
    public void searchCustomers(@RequestParam(required = false) String lastName){
        System.out.println("Search Customer called.");
//        return Collections.emptyList();
    }

    @PostMapping("/api/customer/{customerID}")
    public void getCustomers(@PathVariable Long customerID) {
        System.out.println("Get customer called: " + customerID);
    }
    @GetMapping("/api/customers/{customerId}")
    public void getCustomer(@PathVariable Long customerId){
        System.out.println("get customer called ID:" + customerId);
    }
    @PutMapping("/api/customer/{customerID}")
    public void updateCustomer(@PathVariable Long customerID){
        System.out.println("update customer called: id = " + customerID);
    }

    @DeleteMapping("/api/customers/{customerId}")
    public void deleteCustomer(@PathVariable Long customerId){
        System.out.println("Customer with ID:" + customerId);
    }


}
