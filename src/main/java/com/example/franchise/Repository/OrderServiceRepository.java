package com.example.franchise.Repository;

import com.example.franchise.Entitiy.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderServiceRepository  extends JpaRepository<Order,Long> {
}
