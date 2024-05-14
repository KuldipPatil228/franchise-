package com.example.franchise.DTO.RequstDto;

import com.example.franchise.Entitiy.DeliveryDetails;

import java.util.Date;

public record CreateOrderRequest(
        Long userId,
        Long orderItemId,
        Date orderDate,
        double totalAmount,
        DeliveryDetails DeliveryDetails
) {

}
