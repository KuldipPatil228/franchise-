package com.example.franchise.service;

import com.example.franchise.DTO.CustomerDetailsDTO;
import com.example.franchise.Entitiy.CustomerDetails;

public interface CustomerDetailsService {
    CustomerDetailsDTO getCustomerDetailsById(Long id);

    CustomerDetailsDTO createCustomerDetails(CustomerDetails customerDetails);


    CustomerDetailsDTO updateCustomerDetails(Long id, CustomerDetailsDTO customerDetailsDTO);

    void deleteCustomerDetails(Long id);
}
