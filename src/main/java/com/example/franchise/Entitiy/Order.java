package com.example.franchise.Entitiy;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany
    private List<Item> orderItems;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private DeliveryDetails deliveryDetails;

    private Date orderDate;

    private double totalAmount;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Item> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<Item> orderItems) {
        this.orderItems = orderItems;
    }

    public DeliveryDetails getDeliveryDetails() {
        return deliveryDetails;
    }

    public void setDeliveryDetails(DeliveryDetails deliveryDetails) {
        this.deliveryDetails = deliveryDetails;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Order() {
    }

    public Order(DeliveryDetails deliveryDetails, Long id, Date orderDate, List<Item> orderItems, double totalAmount, User user) {
        this.deliveryDetails = deliveryDetails;
        this.id = id;
        this.orderDate = orderDate;
        this.orderItems = orderItems;
        this.totalAmount = totalAmount;
        this.user = user;
    }

//    private OrderStatus status;
}
