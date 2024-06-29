package com.example.franchise.Repository;

import com.example.franchise.Entitiy.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranchiseRepository extends JpaRepository<Franchise,Long>  {

}
