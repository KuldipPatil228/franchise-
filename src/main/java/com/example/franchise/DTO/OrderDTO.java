package com.example.franchise.DTO;

import com.example.franchise.Entitiy.DeliveryDetails;
import com.example.franchise.Entitiy.Item;
import com.example.franchise.Entitiy.User;

import java.util.Date;
import java.util.List;

public record OrderDTO(

        Long id,
        User user,
        List<Item> items,

        DeliveryDetails deliveryDetails,

        Date orderDate,
        double totalAmount
) {
}
