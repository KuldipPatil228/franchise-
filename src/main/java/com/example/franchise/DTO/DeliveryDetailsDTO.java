package com.example.franchise.DTO;

import com.example.franchise.Entitiy.Order;
import com.example.franchise.Enums.DeliveryMethod;

import java.util.Date;

public record DeliveryDetailsDTO(

        Long id,
        Order order,

        DeliveryMethod deliveryMethod,
        String address,
        Date deliveryTime
) {
}
