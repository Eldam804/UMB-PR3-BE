package sk.umb.example.library.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.umb.example.library.customer.persistence.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    private final List<CustomerDto> customers = new ArrayList<>();


    public List<CustomerDto> getAllCustomers() {
        return customers;
    }

    public CustomerDto getCustomerById(Long customerId) {
        int index = customerId.intValue();
        if(index < customers.size()){
            return customers.get(index);
        }
        return new CustomerDto();
    }

    public Long createNewCustomer(CustomerRequestDto customer) {
        Long customerId = (long)customers.size();
        CustomerDto customerDto = mapToCustomerDto(customer);
        customerDto.setId(customerId);
        customers.add(customerDto);
        return customerId;

    }
    private static CustomerDto mapToCustomerDto(CustomerRequestDto customer){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setContact(customer.getContact());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        return customerDto;
    }

    public void updateCustomer(Long customerId, CustomerRequestDto customer) {
        int index = customerId.intValue();
        CustomerDto customerDto = mapToCustomerDto(customer);
        if(index < customers.size()){
            customers.get(index).setFirstName(customerDto.getFirstName());
            customers.get(index).setLastName(customerDto.getLastName());
            customers.get(index).setContact(customerDto.getContact());
        }
    }
}
