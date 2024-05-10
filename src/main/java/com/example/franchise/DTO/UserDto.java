package com.example.franchise.DTO;

import com.example.franchise.Enums.UserType;

public record UserDto(
        Long id,
        String name,
        String email,

        String mobileNumber,

        UserType userType
) {

}
