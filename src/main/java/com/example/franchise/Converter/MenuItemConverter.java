package com.example.franchise.Converter;

import com.example.franchise.DTO.MenuItemDTO;
import com.example.franchise.Entitiy.MenuItem;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MenuItemConverter extends AbstractConverter<MenuItemDTO, MenuItem> {

    // Constructor defining conversion logic using lambda expressions
    public MenuItemConverter() {
        super(
                // Conversion logic from MenuItemDto to MenuItem
                menuItemDto -> {
                    MenuItem menuItem = new MenuItem();
                    menuItem.setItemName(menuItemDto.itemName());
                    menuItem.setAmount(menuItemDto.amount());
                    menuItem.setCategory(menuItemDto.category());
//                    menuItem.setCategory(menuItemDto.getCategory());
//                    menuItem.setQuantity(menuItemDto.getQuantity());
                    return menuItem;
                },
                menuItem -> new MenuItemDTO(
                        menuItem.getId(),
                        menuItem.getItemName(),
                        null,
                        menuItem.getAmount(),
                        menuItem.getCategory()
                )
        );
    }

    // Method to update MenuItem entity with data from MenuItemDto
    public MenuItem update(MenuItem menuItem, MenuItemDTO menuItemDto) {
        menuItem.setItemName(menuItemDto.itemName());
        menuItem.setAmount(menuItemDto.amount());
        menuItem.setCategory(menuItemDto.category());
        return menuItem;
    }

    public MenuItemDTO convertToDTO(MenuItem menuItem) {
        return new MenuItemDTO(
                menuItem.getId(),
                menuItem.getItemName(),
                null,
                menuItem.getAmount(),
                menuItem.getCategory()
        );
    }

    // Define toDTOList method to convert a list of MenuItem entities to a list of MenuItemDTO objects
    public List<MenuItemDTO> toDTOList(List<MenuItem> menuItemList) {
        return menuItemList.stream()
                .map(this::convertToDTO) // Use convertToDTO method
                .collect(Collectors.toList());
    }
}
