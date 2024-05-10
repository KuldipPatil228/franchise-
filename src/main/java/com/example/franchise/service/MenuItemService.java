package com.example.franchise.service;

import com.example.franchise.DTO.MenuItemDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MenuItemService {

    List<MenuItemDTO> getAllMenuItems();

    MenuItemDTO addMenuItem(MenuItemDTO menuItemDTO);

    List<MenuItemDTO> getAllMenuItemsByCategory(String category);

    MenuItemDTO updateMenuItem(MenuItemDTO menuItemDTO);

    void deleteByMenuItemId(Long menuItemId);
}
