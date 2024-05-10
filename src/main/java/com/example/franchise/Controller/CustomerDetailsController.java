package com.example.franchise.Controller;

import com.example.franchise.DTO.CustomerDetailsDTO;
import com.example.franchise.Entitiy.CustomerDetails;
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

    @GetMapping("/{id}")
    public CustomerDetailsDTO getCustomerDetailsById(@PathVariable Long id) {
        return customerDetailsService.getCustomerDetailsById(id);
    }

    @PostMapping("/api/create/CustomerDetails")
    public CustomerDetailsDTO createCustomerDetails(@RequestBody CustomerDetails customerDetails) {
        return customerDetailsService.createCustomerDetails(customerDetails);
    }

    @PutMapping("/api/update/CustomerDetails/{id}")
    public CustomerDetailsDTO updateCustomerDetails(@PathVariable Long id, @RequestBody CustomerDetailsDTO customerDetails) {
        return customerDetailsService.updateCustomerDetails(id, customerDetails);
    }

    @DeleteMapping("/api/delete/CustomerDetails/{id}")
    public void deleteCustomerDetails(@PathVariable Long id) {
        customerDetailsService.deleteCustomerDetails(id);
    }


}
