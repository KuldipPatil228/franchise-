package com.example.franchise.DTO;

import com.example.franchise.Entitiy.MenuItem;
import com.example.franchise.Entitiy.Order;


public record OrderItemDTO(
        Long id,

        Order order,
        MenuItem menuItem,
        int quantity,
        double totalPrice
) {
}
