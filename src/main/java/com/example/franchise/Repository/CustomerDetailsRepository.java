package com.example.franchise.Repository;


import com.example.franchise.Entitiy.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails,Long> {
}
