package com.example.franchise.service.serviceImpl;

import com.example.franchise.DTO.MenuItemDTO;
import com.example.franchise.Entitiy.MenuItem;
import com.example.franchise.Repository.MenuItemRepository;
import com.example.franchise.Util.ConverterUtil;
import com.example.franchise.service.MenuItemService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    private  final MenuItemRepository menuItemRepository;


    private static final Logger log = Logger.getLogger(MenuItemServiceImpl.class.getName());

    public MenuItemServiceImpl(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public MenuItemDTO addMenuItem(MenuItemDTO menuItemDTO) {
        MenuItem ManuItem = ConverterUtil.menuItemConverter().toEntity(menuItemDTO);
        MenuItem saveManuItem = menuItemRepository.save(ManuItem);
        return ConverterUtil.menuItemConverter().toDto(saveManuItem);
    }


    @Override
    public List<MenuItemDTO> getAllMenuItemsByCategory(String category) {
//        List<MenuItem> menuItems = menuItemRepository.getMenuItemsByCategory(category);

        return null;
//        ConverterUtil.menuItemConverter().toDTOList(menuItems);
    }

    @Override
    public MenuItemDTO updateMenuItem(MenuItemDTO menuItemDTO) {
        MenuItem menuItem = getValidateMenuItem(menuItemDTO.id());
        MenuItem UpdatedMenuItem = menuItemRepository.save(ConverterUtil.menuItemConverter().update(menuItem, menuItemDTO));
        return ConverterUtil.menuItemConverter().toDto(UpdatedMenuItem);
    }

    @Override
    public void deleteByMenuItemId(Long menuItemId) {
        if (getValidateMenuItem(menuItemId) != null) {
            menuItemRepository.deleteById(menuItemId);
        } else {
            throw new IllegalArgumentException("Menu item with ID " + menuItemId + " does not exist");
        }
    }


    @Override
    public List<MenuItemDTO> getAllMenuItems() {
        List<MenuItem> menuItems = menuItemRepository.findAll();
        return ConverterUtil.menuItemConverter().toDTOList(menuItems);
    }


    private MenuItem getValidateMenuItem(Long id) {
        Optional<MenuItem> menuItem = menuItemRepository.findById(id);
        return menuItem.orElse(null);
    }

}
