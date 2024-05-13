package com.example.franchise.DTO.RequstDto;

import com.example.franchise.DTO.CustomerDetailsDTO;
import com.example.franchise.Entitiy.User;


public record CreateCustomerDetailsRequest(
        Long id,
        User user,
        String address,
        String paymentMethod
) {
    public CustomerDetailsDTO CreateCustomerDetails() {
        return new CustomerDetailsDTO(null, user, address, paymentMethod);
    }

}
