package com.example.franchise.Entitiy;

import com.example.franchise.Enums.DeliveryMethod;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;

import java.util.Date;
@Entity
@Data
@Getter
@Setter
public class DeliveryDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "order_id", nullable = false, unique = true)
    private Order order;

    @Enumerated(EnumType.STRING)
    private DeliveryMethod deliveryMethod;

    @OneToOne
    private UserAddress userAddress;

    @Temporal(TemporalType.TIMESTAMP)
    private Date deliveryTime;
}
