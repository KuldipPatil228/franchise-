package com.example.franchise.DTO;

import com.example.franchise.Enums.Category;

import java.awt.*;

public record MenuItemDTO(
        Long id,

        String itemName,

        Long quantity,

        double amount,

        Category category
) {

}
