package com.example.franchise.DTO;

import com.example.franchise.Enums.UserType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record UserDto(
        Long id,

        String name,

        String email,

        String mobileNumber,

        String userName,

        String password,

        @Enumerated(EnumType.STRING)
        UserType userType
) {
}
