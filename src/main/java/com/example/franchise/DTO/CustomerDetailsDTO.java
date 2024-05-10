package com.example.franchise.DTO;

import com.example.franchise.Entitiy.User;


public record CustomerDetailsDTO(
        Long id,
        User user,
        String address,
        String paymentMethod
) {
}
