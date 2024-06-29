package com.example.franchise.Converter;

import com.example.franchise.DTO.OrderDTO;
import com.example.franchise.Entitiy.Order;


public class OrderConverter extends AbstractConverter<OrderDTO, Order>{

    public OrderConverter() {
        super(
                // Conversion logic from OrderDTO to Order
                dto -> {
                    Order order = new Order();
//                    order.se(dto.getId());
//                    order.setUser(dto.getUser());
//                    order.setOrderItems(dto.getOrderItems());
                    order.setDeliveryDetails(dto.deliveryDetails());
                    order.setOrderDate(dto.orderDate());
                    order.setTotalAmount(dto.totalAmount());
                    return order;
                },
                // Conversion logic from Order to OrderDTO
                order -> new OrderDTO(
                        order.getId(),
                        order.getUser(),
                        null,
                        order.getDeliveryDetails(),
                        order.getOrderDate(),
                        order.getTotalAmount()
                )
        );
    }
    public Order updateEntity(OrderDTO dto, Order entity) {
        entity.setUser(dto.user());
        entity.setDeliveryDetails(dto.deliveryDetails());
        entity.setOrderDate(dto.orderDate());
        entity.setTotalAmount(dto.totalAmount());
        return entity;
    }
}
