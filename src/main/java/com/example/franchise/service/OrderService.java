package com.example.franchise.service;

import com.example.franchise.DTO.OrderDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

public interface OrderService {
    ResponseEntity<OrderDTO> createOrder(OrderDTO orderDTO);

    OrderDTO getOrderById(Long id);

    OrderDTO updateOrder(Long id, OrderDTO orderDTO);

    void deleteOrder(Long id);
}
