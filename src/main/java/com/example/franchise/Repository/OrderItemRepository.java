package com.example.franchise.Repository;

import com.example.franchise.Entitiy.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<Item, Long> {

}
