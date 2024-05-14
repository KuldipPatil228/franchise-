package com.example.franchise.service;

import com.example.franchise.DTO.OrderDTO;
import com.example.franchise.DTO.RequstDto.CreateOrderRequest;
import org.springframework.http.ResponseEntity;

public interface OrderService {
    ResponseEntity<OrderDTO> createOrder(CreateOrderRequest orderRequest);

    OrderDTO getOrderById(Long id);

    OrderDTO updateOrder(Long id, OrderDTO orderDTO);

    void deleteOrder(Long id);
}
