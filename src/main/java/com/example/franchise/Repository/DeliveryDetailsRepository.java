package com.example.franchise.Repository;

import com.example.franchise.Entitiy.DeliveryDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryDetailsRepository extends JpaRepository<DeliveryDetails,Long> {
}
