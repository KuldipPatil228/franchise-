package com.example.franchise.DTO.RequstDto;

import com.example.franchise.DTO.CustomerDetailsDTO;
import com.example.franchise.Entitiy.User;

public record updateCustomerDetailsRequest(
        Long id,
        User user,
        String address,
        String paymentMethod
) {
    public CustomerDetailsDTO updateCustomerDetails() {
        return new CustomerDetailsDTO(id, user, address, paymentMethod);
    }
}
