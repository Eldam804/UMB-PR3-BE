package sk.umb.example.library.customer.service;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.umb.example.library.customer.persistence.CustomerRepository;
import sk.umb.example.library.customer.persistence.entity.CustomerEntity;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    private final List<CustomerDto> customers = new ArrayList<>();


    public List<CustomerDto> getAllCustomers() {
        return maptoDtoList(customerRepository.findAll());
    }

    private List<CustomerDto> maptoDtoList(Iterable<CustomerEntity> all) {
        List<CustomerDto> customers = new ArrayList<>();
        all.forEach(customerEntity -> {
            CustomerDto dto = mapToDto(customerEntity);
            customers.add(dto);
        });
        return customers;
    }

    private CustomerDto mapToDto(CustomerEntity customerEntity) {
        CustomerDto dto = new CustomerDto();
        dto.setId(customerEntity.getId());
        dto.setFirstName(customerEntity.getFirstName());
        dto.setLastName(customerEntity.getLastName());
        dto.setContact(customerEntity.getContact());
        return dto;
    }

    public CustomerDto getCustomerById(Long customerId) {
        return mapToDto(getCustomerEntityById(customerId));
    }

    private CustomerEntity getCustomerEntityById(Long customerId) {
        Optional<CustomerEntity> customer = customerRepository.findById(customerId);
        if(customer.isEmpty()){
            throw new IllegalArgumentException("Customer not found. ID: " + customerId);
        }
        return customer.get();
    }

    @Transactional
    public Long createNewCustomer(CustomerRequestDto customer) {
        CustomerEntity entity = mapToEntity(customer);

        return customerRepository.save(entity).getId();
    }

    @Transactional
    public void deleteCustomer(Long customerId){
        customerRepository.deleteById(customerId);
    }

    private CustomerEntity mapToEntity(CustomerRequestDto customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setFirstName(customer.getFirstName());
        customerEntity.setLastName(customerEntity.getLastName());
        customerEntity.setContact(customerEntity.getContact());
        return customerEntity;
    }

    private static CustomerDto mapToCustomerDto(CustomerRequestDto customer){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setContact(customer.getContact());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        return customerDto;
    }

    public void updateCustomer(Long customerId, CustomerRequestDto customer) {
        CustomerEntity customerEntity = getCustomerEntityById(customerId);

        if(!Strings.isEmpty(customer.getFirstName())){
            customerEntity.setFirstName(customer.getFirstName());
        }
        if(!Strings.isEmpty(customer.getLastName())){
            customerEntity.setLastName(customer.getLastName());
        }
        if(!Strings.isEmpty(customer.getContact())){
            customerEntity.setContact(customer.getContact());
        }
        customerRepository.save(customerEntity);
    }
}
