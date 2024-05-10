package com.example.franchise.service.serviceImpl;

import com.example.franchise.DTO.OrderDTO;
import com.example.franchise.Entitiy.Order;
import com.example.franchise.Repository.OrderServiceRepository;
import com.example.franchise.Repository.UserRepository;
import com.example.franchise.Util.ConverterUtil;
import com.example.franchise.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderServiceRepository orderRepository;
    private final UserRepository userRepository;

    public OrderServiceImpl(OrderServiceRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }


    @Override
    public ResponseEntity<OrderDTO> createOrder(OrderDTO orderDTO) {
        Order order = ConverterUtil.orderConverter().toEntity(orderDTO);
        Order savedOrder = orderRepository.save(order);
        OrderDTO savedOrderDTO = ConverterUtil.orderConverter().toDto(savedOrder);
        return new ResponseEntity<>(savedOrderDTO, HttpStatus.CREATED);
    }

    @Override
    public OrderDTO getOrderById(Long id) {
        Order order = getOrderIfExists(id);
        return ConverterUtil.orderConverter().toDto(order);
    }

    @Override
    public OrderDTO updateOrder(Long id, OrderDTO orderDTO) {
        Order order = getOrderIfExists(id);
        order = ConverterUtil.orderConverter().updateEntity(orderDTO, order);
        Order updatedOrder = orderRepository.save(order);
        return ConverterUtil.orderConverter().toDto(updatedOrder);
    }

    @Override
    public void deleteOrder(Long id) {
        Order order = getOrderIfExists(id);
        orderRepository.delete(order);
    }

    private Order getOrderIfExists(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
    }

}
