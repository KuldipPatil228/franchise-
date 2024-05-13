package com.example.franchise.service;

import com.example.franchise.DTO.CustomerDetailsDTO;

public interface CustomerDetailsService {
    CustomerDetailsDTO getCustomerDetailsById(Long id);

    CustomerDetailsDTO createCustomerDetails( CustomerDetailsDTO customerDetailsDTO);


    CustomerDetailsDTO updateCustomerDetails(CustomerDetailsDTO customerDetailsDTO);

    String deleteCustomerDetails(Long id);
}
