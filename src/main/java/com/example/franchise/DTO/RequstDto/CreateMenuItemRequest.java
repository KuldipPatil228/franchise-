package com.example.franchise.DTO.RequstDto;

import com.example.franchise.DTO.MenuItemDTO;
import com.example.franchise.Enums.Category;


public record CreateMenuItemRequest(

        String itemName,

        Long quantity,

        double amount,

        Category category
) {
    public MenuItemDTO prepareMenuItems() {
        return new MenuItemDTO(null, itemName, quantity, amount, category);
    }
}
