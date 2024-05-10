package com.example.franchise.Repository;

import com.example.franchise.DTO.MenuItemDTO;
import com.example.franchise.Entitiy.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem,Long> {

    List<MenuItem> getMenuItemsByCategory(String category);
}
