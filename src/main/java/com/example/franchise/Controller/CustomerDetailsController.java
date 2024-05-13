package com.example.franchise.Controller;

import com.example.franchise.DTO.CustomerDetailsDTO;
import com.example.franchise.DTO.RequstDto.CreateCustomerDetailsRequest;
import com.example.franchise.DTO.RequstDto.updateCustomerDetailsRequest;
import com.example.franchise.service.CustomerDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
public class CustomerDetailsController {
    private static final Logger log = Logger.getLogger(CustomerDetailsController.class.getName());



   private final CustomerDetailsService customerDetailsService;

    public CustomerDetailsController(CustomerDetailsService customerDetailsService) {
        this.customerDetailsService = customerDetailsService;
    }


    @PostMapping("/api/create/CustomerDetails")
    public CustomerDetailsDTO createCustomerDetails(@RequestBody CreateCustomerDetailsRequest createCustomerDetailsRequest) {
        return customerDetailsService.createCustomerDetails(createCustomerDetailsRequest.CreateCustomerDetails());
    }

    @GetMapping("/api/read/CustomerDetails/{id}")
    public CustomerDetailsDTO getCustomerDetailsById(@PathVariable Long id) {
        return customerDetailsService.getCustomerDetailsById(id);
    }

    @PutMapping("/api/update/CustomerDetails")
    public CustomerDetailsDTO updateCustomerDetails(@RequestBody updateCustomerDetailsRequest updateCustomerDetailsRequest) {
        return customerDetailsService.updateCustomerDetails(updateCustomerDetailsRequest.updateCustomerDetails());
    }

    @DeleteMapping("/api/delete/CustomerDetails/{id}")
    public void deleteCustomerDetails(@PathVariable Long id) {
        customerDetailsService.deleteCustomerDetails(id);
    }


}
