package com.example.franchise.DTO.RequstDto;

import com.example.franchise.DTO.MenuItemDTO;
import com.example.franchise.Enums.Category;

public record UpdateMenuItemRequest(
        Long id,

        String itemName,

        Long quantity,

        double amount,

        Category category
) {
    public MenuItemDTO prepareMenuItemsUpdate() {
        return new MenuItemDTO(id, itemName, quantity, amount, category);
    }

}
