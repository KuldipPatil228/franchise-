package com.example.franchise.Util;

import com.example.franchise.Converter.*;

public class ConverterUtil {

    public static UserConverter userConverter() {
        return new UserConverter();
    }

    public static MenuItemConverter  menuItemConverter() {
        return new MenuItemConverter();
    }

    public static CustomerDetailsConverter customerDetailsConverter() {
        return new CustomerDetailsConverter();
    }
    public static OrderConverter orderConverter() {
        return new OrderConverter();
    }

    public static FranchiseConverter franchiseConverter() {
        return new FranchiseConverter();
    }


}
