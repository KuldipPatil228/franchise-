package com.example.franchise.service.serviceImpl;

import com.example.franchise.DTO.OrderDTO;
import com.example.franchise.DTO.OrderItemDTO;
import com.example.franchise.DTO.RequstDto.CreateOrderRequest;
import com.example.franchise.Entitiy.DeliveryDetails;
import com.example.franchise.Entitiy.Order;
import com.example.franchise.Entitiy.OrderItem;
import com.example.franchise.Entitiy.User;
import com.example.franchise.Enums.MessageType;
import com.example.franchise.Exception.ApiException;
import com.example.franchise.Repository.DeliveryDetailsRepository;
import com.example.franchise.Repository.OrderItemRepository;
import com.example.franchise.Repository.OrderServiceRepository;
import com.example.franchise.Repository.UserRepository;
import com.example.franchise.Util.ConverterUtil;
import com.example.franchise.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderServiceRepository orderRepository;
    private final UserRepository userRepository;
    private final OrderItemRepository orderItemRepository;

    private final DeliveryDetailsRepository deliveryDetailsRepository;

    public OrderServiceImpl(OrderServiceRepository orderRepository, UserRepository userRepository, OrderItemRepository orderItemRepository, DeliveryDetailsRepository deliveryDetailsRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.orderItemRepository = orderItemRepository;
        this.deliveryDetailsRepository = deliveryDetailsRepository;
    }


    @Override
    public ResponseEntity<OrderDTO> createOrder(CreateOrderRequest orderDTO) {

        User user = fetchUser(orderDTO.userId());
        OrderItem orderItem = fetchOrderItem(orderDTO.orderItemId());
//        DeliveryDetails deliveryDetails = fetchDeliveryDetails(orderDTO.deliveryDetailsId());
        Order order = new Order();
        order.setUser(user);
        order.setOrderItems(Arrays.asList(orderItem));
        order.setOrderDate(orderDTO.orderDate());
//        order.setDeliveryDetails(deliveryDetails);
        order.setOrderDate(orderDTO.orderDate());
        order.setTotalAmount(orderDTO.totalAmount());

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
                .orElseThrow(() -> new ApiException(MessageType.NOT_FOUND_ENTITY, "Order not found for Id :" + id));
    }


    private User fetchUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ApiException(MessageType.NOT_FOUND_USER, "User not found for id: " + userId));
    }

    private OrderItem fetchOrderItem(Long orderItemId) {
        return orderItemRepository.findById(orderItemId)
                .orElseThrow(() -> new ApiException(MessageType.NOT_FOUND_ENTITY, "Order Item found for id: " + orderItemId));
    }

    private DeliveryDetails fetchDeliveryDetails(Long deliveryItemId) {
        return deliveryDetailsRepository.findById(deliveryItemId)
                .orElseThrow(() -> new ApiException(MessageType.NOT_FOUND_ENTITY, "Delivery Details found for id: " + deliveryItemId));
    }
}
