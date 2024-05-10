package com.example.franchise.DTO;

import com.example.franchise.Entitiy.DeliveryDetails;
import com.example.franchise.Entitiy.OrderItem;
import com.example.franchise.Entitiy.User;

import java.util.Date;
import java.util.List;

public record OrderDTO(

        Long id,

        User user,
        List<OrderItem> orderItems,

        DeliveryDetails deliveryDetails,

        Date orderDate,
        double totalAmount
) {
}
