package com.example.franchise.Controller;


import com.example.franchise.DTO.MenuItemDTO;
import com.example.franchise.DTO.RequstDto.CreateMenuItemRequest;
import com.example.franchise.DTO.RequstDto.UpdateMenuItemRequest;
import com.example.franchise.Entitiy.MenuItem;
import com.example.franchise.service.MenuItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class MenuItemController {
    private static  final Logger log = Logger.getLogger(MenuItemController.class.getName());

    private  final MenuItemService menuItemService;

    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @PostMapping("/api/create/MenuItems")
    public MenuItemDTO createMenuItem(@RequestBody CreateMenuItemRequest  createMenuItemRequest){
     return  menuItemService.addMenuItem(createMenuItemRequest.prepareMenuItems());
    }

    @PutMapping("/api/update/MenuItems")
    public MenuItemDTO updateMenuItem(@RequestBody UpdateMenuItemRequest updateMenuItemRequest){
       return menuItemService.updateMenuItem(updateMenuItemRequest.prepareMenuItemsUpdate());

    }

    @GetMapping("/api/getAll/MenuItems")
    public List<MenuItemDTO> getAllMenuItems() {
        return menuItemService.getAllMenuItems();
    }

    @GetMapping("/byCategory/{category}")
    public List<MenuItemDTO> getMenuItemsByCategory(@PathVariable String category) {
        return menuItemService.getAllMenuItemsByCategory(category);
    }

    @DeleteMapping("/api/delete/menuItems/{menuItemId}")
    public String delete(@PathVariable Long menuItemId) {
        menuItemService.deleteByMenuItemId(menuItemId);
        return "delete :"+ menuItemId;
    }
}
